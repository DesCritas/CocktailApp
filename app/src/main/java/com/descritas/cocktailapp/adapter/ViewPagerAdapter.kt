package com.descritas.cocktailapp.adapter

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.descritas.cocktailapp.R
import com.descritas.cocktailapp.databinding.ItemPageBinding

class ViewPagerAdapter : RecyclerView.Adapter<PagerVH>() {

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_orange_dark,
        android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        val binding = ItemPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerVH(binding)
    }

    override fun getItemCount(): Int = colors.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        // val res: Resources = Resources.getSystem()
        val holderCont = holder.binding.onbImage.context
        val buttonRes = R.drawable.on_boarding_itm1

        val bitmap: Bitmap = (ContextCompat.getDrawable(holderCont, buttonRes) as BitmapDrawable).bitmap

        holder.binding.tvTitle.text = "item $position"
        holder.binding.container.setBackgroundResource(colors[position])
        holder.binding.onbImage.setImageBitmap(bitmap)
    }
}

class PagerVH(val binding: ItemPageBinding) : RecyclerView.ViewHolder(binding.root)
