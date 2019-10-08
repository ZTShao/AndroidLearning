package com.example.android.zhetai.androidlearning.KotlinExtensions

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

fun View.getString(resInt: Int): String = context.resources.getString(resInt)

fun View.getDrawable(@DrawableRes drawableRes: Int) = context.resources.getDrawable(drawableRes)

fun View.getColor(@ColorRes colorRes: Int): Int = context.resources.getColor(colorRes)

fun View.getDimension(dimenRes: Int): Float = context.resources.getDimension(dimenRes)

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}