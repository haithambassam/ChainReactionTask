package com.haitham.chainreactiontask.ui

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class QuranSajdaDecorator(private val paddingInDp: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val tenDps = view.context.dpToPx(paddingInDp)

        outRect.set(tenDps, tenDps, tenDps, tenDps)
    }
}

fun Context.dpToPx(dp: Int): Int {
    val density = resources.displayMetrics.density
    return (dp * density).toInt()
}