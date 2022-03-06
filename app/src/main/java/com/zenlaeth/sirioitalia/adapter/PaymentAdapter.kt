package com.zenlaeth.sirioitalia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.ArticleDetailsActivity
import com.zenlaeth.sirioitalia.CardPaymentActivity
import com.zenlaeth.sirioitalia.R

class PaymentAdapter: RecyclerView.Adapter<PaymentAdapter.ViewHolder>() {
    val titles = arrayOf("Credit Card or Debit", "Paypal", "Bank Transfert")
    val images = arrayOf(R.drawable.ic_payment, R.drawable.ic_payment_paypal, R.drawable.ic_payment_bank, )

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position : Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.payment_list_item, viewGroup, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.paymentTitle.text = titles[position]
        viewHolder.paymentImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
    inner class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        var paymentImage: ImageView
        var paymentTitle: TextView

        init {
            paymentImage = itemView.findViewById(R.id.payment_image)
            paymentTitle = itemView.findViewById(R.id.payment_title)
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}