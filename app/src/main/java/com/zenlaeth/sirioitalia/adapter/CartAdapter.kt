package com.zenlaeth.sirioitalia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.*
import com.zenlaeth.sirioitalia.activity.HomeActivity
import com.zenlaeth.sirioitalia.models.CartModel

class CartAdapter(
    val context: HomeActivity,
    private val cartList: List<CartModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<CartAdapter.ViewHolder>(){

    // boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val articleImage = view.findViewById<ImageView>(R.id.image_item)
        val articleId:TextView? = view.findViewById(R.id.id_item)
        val articleName:TextView? = view.findViewById(R.id.name_item)
        val articleDescription:TextView? = view.findViewById(R.id.description_item)
        val articlePrice:TextView? = view.findViewById(R.id.price_item)
        val articleQuantity:TextView? = view.findViewById(R.id.quantity_item)

        companion object {
            val articleIdKey = "ARTICLE_ID"
            val articleNameKey = "ARTICLE_NAME"
            val articleImageKey = "ARTICLE_IMAGE"
            val articleDescriptionKey = "ARTICLE_DESCRIPTION"
            val articlePriceKey = "ARTICLE_PRICE"
            val articleQuantityKey = "ARTICLE_QUANTITY"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // recuperer les informations de l'article
        val currentArticle = cartList[position]

        // utiliser glide pour recuperer l'image à partir de son lien -> composant
//        Glide.with(context).load(Uri.parse(currentArticle.imageUrl)).into(holder.articleImage)

        // mettre à jour champs articles
        holder.articleName?.text = currentArticle.item.label
        holder.articleDescription?.text = currentArticle.item.description
        // add quantite, prix et id
//        holder.articleId?.text = currentArticle.id.toString()
        holder.articlePrice?.text = currentArticle.item.price.toString() + " €"
        holder.articleQuantity?.text = currentArticle.quantity.toString()

/*        // mettre à jour l'image (intent extra)
        holder.articleImage?.drawable */
    }

    override fun getItemCount(): Int = cartList.size
}