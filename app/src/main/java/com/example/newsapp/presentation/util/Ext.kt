package com.example.newsapp.presentation.util

import android.content.res.Resources
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Float.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Fragment.showToast(msg: String) {
    Toast.makeText(this.requireContext(), msg, Toast.LENGTH_SHORT).show()
}

