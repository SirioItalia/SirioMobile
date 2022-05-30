package com.zenlaeth.sirioitalia.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.activity.ArticleDetailsActivity
import com.zenlaeth.sirioitalia.R

class ArticleDetailsAdapter(
    private var mListener: onItemClickListener,
    val context: ArticleDetailsActivity,
    private val colorsHexa: String?,
    private val colorsName: String?,
    private val articlesPrice: String?,
    ) : RecyclerView.Adapter<ArticleDetailsAdapter.ViewHolder>(){

    val articlePricesList: List<String>? = articlesPrice?.split("-")?.toList()
    val colorHexaList: List<String>? = colorsHexa?.split("-")?.toList()
    val colorsNameList: List<String>? = colorsName?.split("-")?.toList()

    val colorHexaListToInt = colorHexaList?.map {
        Color.parseColor(it)
    }

    interface onItemClickListener {
        fun onItemClick(position : Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.article_item_color, viewGroup, false)
        return ViewHolder(v, mListener)
    }

    // boite pour ranger tous les composants à controler
    class ViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val colorHexa: TextView? = view.findViewById(R.id.btnArticleItemColorHexa)
        val articlePriceTv: TextView? = view.findViewById(R.id.article_detail_price)

//        companion object {
//            val colorHexa = "COLOR_HEXA"
//            val colorName = "COLOR_NAME"
//        }

//        init {
//            view.setOnClickListener {
//                listener.onItemClick(adapterPosition)
//            }
//        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.colorHexa?.setBackgroundColor(colorHexaListToInt?.get(position)!!)
        viewHolder.colorHexa?.setText(colorsNameList?.get(position))

        viewHolder.colorHexa?.setOnClickListener{
            Toast.makeText(context, "Choosed the " + colorsNameList?.get(position) + " color", Toast.LENGTH_LONG).show()
            viewHolder.articlePriceTv?.text = articlePricesList?.get(position)
        }
    }

    override fun getItemCount(): Int = colorHexaList!!.size
}