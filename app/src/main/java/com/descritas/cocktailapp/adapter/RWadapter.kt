package com.descritas.cocktailapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.descritas.cocktailapp.R
import com.descritas.cocktailapp.databinding.CocktailCardBinding
import com.descritas.cocktailapp.databinding.IngredientItemBinding
import com.descritas.cocktailapp.dto.Card
import com.descritas.cocktailapp.dto.Data
import com.descritas.cocktailapp.dto.Ingredient
import com.descritas.cocktailapp.load

class RWAdapter(context: Context, list: ArrayList<Data>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }
    private val context: Context = context
    var list: ArrayList<Data> = list


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val bindingIngr = IngredientItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val bindingCard = CocktailCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        if (viewType == VIEW_TYPE_ONE) {
            return MyCardViewHolder(
                bindingCard
            )
        }
        return MyListViewHolder(
            bindingIngr
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].viewType == VIEW_TYPE_ONE) {
            (holder as MyCardViewHolder).bind(position)
        } else {
            (holder as MyListViewHolder).bind(position)
        }
    }

    private inner class MyCardViewHolder(
        private val binding: CocktailCardBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            val recyclerViewModel = list[position]
            val card = recyclerViewModel.card
            binding.apply {
                cocktailId.text = card.id.toString()
                name.text = card.name
                cocktailCat.text = card.category
                cocktailType.text = card.type
                glassType.text = card.glass
                content.text = card.instruction
                cocktailImg.load(card.imgThumbLink)
                like.isChecked = card.likedByMe
            }
        }
    }

    private inner class MyListViewHolder(
        private val binding: IngredientItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int){
            val recyclerViewModel1 = list[position]
            val ingredients = recyclerViewModel1.ingredients
            binding.apply {
                ingredient.text = ingredients[1].ingredient
                measure.text = ingredients[1].measure
            }
        }
    }



}




/*
class DiffCallback : DiffUtil.ItemCallback<Ingredient>() {
    override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem.ingredient == newItem.ingredient
    }

    override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem == newItem
    }
}*/
