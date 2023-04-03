package com.descritas.cocktailapp.view

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.descritas.cocktailapp.R

const val TIMEOUT = 10_000

fun ImageView.load(url: String?, vararg transforms: BitmapTransformation = emptyArray()) =
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.ic_loading_100dp)
        .error(R.drawable.ic_error_100dp)
        .timeout(TIMEOUT)
        .transform(*transforms)
        .into(this)
