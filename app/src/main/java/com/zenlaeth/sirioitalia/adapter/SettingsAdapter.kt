package com.zenlaeth.sirioitalia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.R

class SettingsAdapter: RecyclerView.Adapter<SettingsAdapter.ViewHolder>() {
    val titles = arrayOf("Profile", "Order", "Address", "Payment")
    val images = arrayOf(R.drawable.ic_profile, R.drawable.ic_order, R.drawable.ic_address, R.drawable.ic_payment)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.settings_list_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.settingsTitle.text = titles[i]
        viewHolder.settingsImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var settingsImage: ImageView
        var settingsTitle: TextView

        init {
            settingsImage = itemView.findViewById(R.id.settings_image)
            settingsTitle = itemView.findViewById(R.id.settings_title)
        }
    }
}