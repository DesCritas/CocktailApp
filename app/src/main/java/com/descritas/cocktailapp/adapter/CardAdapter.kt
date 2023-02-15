package com.descritas.cocktailapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.descritas.cocktailapp.dto.Card
import com.descritas.cocktailapp.databinding.CocktailCardBinding
import com.descritas.cocktailapp.load

interface OnInteractionListener {
    fun onLike(id: Long) {}
}

class CardAdapter(private val onInteractionListener: OnInteractionListener) :
    ListAdapter<Card, CardViewHolder>(CardDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding =
            CocktailCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding, onInteractionListener)

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class CardViewHolder(
    private val binding: CocktailCardBinding,
    private val onInteractionListener: OnInteractionListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(card: Card) {
        binding.apply{
            cocktailId.text = card.id.toString()
            name.text = card.name
            cocktailCat.text = card.category
            cocktailType.text = card.type
            glassType.text = card.glass
            content.text = card.instruction
            //TODO ingr's&measures
            cocktailImg.load(card.imgLink)
            like.isChecked = card.likedByMe
            like.setOnClickListener {
                onInteractionListener.onLike(card.id)
            }
        }




    }

}

class CardDiffCallback : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }
}
