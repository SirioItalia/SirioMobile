package com.zenlaeth.sirioitalia.adapter

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class ArticleItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        outRect.bottom = 20
    }
}