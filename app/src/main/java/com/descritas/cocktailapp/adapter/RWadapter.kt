package com.descritas.cocktailapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.descritas.cocktailapp.databinding.CocktailCardBinding
import com.descritas.cocktailapp.databinding.IngredientItemBinding
import com.descritas.cocktailapp.dto.Data
import com.descritas.cocktailapp.view.load

class RWAdapter : ListAdapter<Data, RecyclerView.ViewHolder>(DiffCallback()) {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bindingIngr = IngredientItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val bindingCard = CocktailCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        if (viewType == VIEW_TYPE_ONE) {
            return MyCardViewHolder(bindingCard)
        }
        return MyListViewHolder(bindingIngr)
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItem(position).viewType == VIEW_TYPE_ONE) {
            (holder as MyCardViewHolder).bind(position)
        } else {
            (holder as MyListViewHolder).bind(position)
        }
    }

    private inner class MyCardViewHolder(
        private val binding: CocktailCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val recyclerViewModel = getItem(position)
            val card = recyclerViewModel.card
            binding.apply {
                cocktailId.text = card.id.toString()
                name.text = card.name
                cocktailCat.text = card.category
                cocktailType.text = card.type
                glassType.text = card.glass
                content.text = card.instruction
                cocktailImg.load(card.imgThumbLink)
            }
        }
    }

    private inner class MyListViewHolder(
        private val binding: IngredientItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val recyclerViewModel1: Data = getItem(position)
            val ingredients = recyclerViewModel1.ingredients
            if (ingredients != null) {
                binding.apply {
                    ingredient.text = ingredients.ingredient
                    measure.text = ingredients.measure
                }
            }
        }
    }
}
class DiffCallback : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.viewType == newItem.viewType &&
            oldItem.card == newItem.card &&
            oldItem.ingredients == newItem.ingredients
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}
