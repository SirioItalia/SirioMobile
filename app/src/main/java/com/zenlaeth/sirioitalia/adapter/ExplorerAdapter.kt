package com.zenlaeth.sirioitalia.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.HomeActivity
import com.zenlaeth.sirioitalia.R
import com.zenlaeth.sirioitalia.models.CategoryModel

class ExplorerAdapter(
    private var mListener: onItemClickListener,
    val context: HomeActivity,
    private val categoryList: List<CategoryModel>,
    ): RecyclerView.Adapter<ExplorerAdapter.ViewHolder>() {

    val images = arrayOf(R.mipmap.icon_table, R.mipmap.icon_chair, R.mipmap.icon_sofa, R.mipmap.icon_armchair, R.mipmap.icon_desk)

/*    private lateinit var mListener : onItemClickListener*/

    interface onItemClickListener {
        fun onItemClick(position : Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.explorer_categories_list_item, viewGroup, false)
        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val currentCategory = categoryList[i]
        viewHolder.explorerTitle.text = currentCategory.label
        viewHolder.explorerImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
    inner class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        var explorerImage: ImageView
        var explorerTitle: TextView

        init {
            explorerImage = itemView.findViewById(R.id.explorer_image)
            explorerTitle = itemView.findViewById(R.id.explorer_title)
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}