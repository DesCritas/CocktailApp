package com.descritas.cocktailapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.descritas.cocktailapp.databinding.IngredientItemBinding
import com.descritas.cocktailapp.dto.Ingredient

class IngredientsListAdapter: ListAdapter<Ingredient, MyListViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val binding = IngredientItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        val ingredient = getItem(position)
        holder.bind(ingredient)
    }

}
class MyListViewHolder(
    private val binding: IngredientItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(ingredient1: Ingredient){
        binding.apply {
            ingredient.text = ingredient1.ingredient
            measure.text = ingredient1.measure
        }
    }

}
class DiffCallback : DiffUtil.ItemCallback<Ingredient>() {
    override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem.ingredient == newItem.ingredient
    }

    override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient): Boolean {
        return oldItem == newItem
    }
}