package com.zenlaeth.sirioitalia.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.ArticleDetailsActivity
import com.zenlaeth.sirioitalia.R

class ArticleDetailsAdapter(
    val context: ArticleDetailsActivity,
    private val colorsHexa: String?,
    private val colorsName: String?,
    ) : RecyclerView.Adapter<ArticleDetailsAdapter.ViewHolder>(){

    val colorHexaList: List<String>? = colorsHexa?.split("-")?.toList()
    val colorsNameList: List<String>? = colorsName?.split("-")?.toList()

    val colorHexaListToInt = colorHexaList?.map {
        Color.parseColor(it)
    }

    // boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val colorHexa: TextView? = view.findViewById(R.id.btnArticleItemColorHexa)

        companion object {
            val colorHexa = "COLOR_HEXA"
            val colorName = "COLOR_NAME"
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.article_item_color, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.colorHexa?.setBackgroundColor(colorHexaListToInt?.get(position)!!)
        viewHolder.colorHexa?.setText(colorsNameList?.get(position))
    }

    override fun getItemCount(): Int = colorHexaList!!.size
}