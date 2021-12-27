package com.zenlaeth.sirioitalia.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zenlaeth.sirioitalia.ArticleModel
import com.zenlaeth.sirioitalia.ArticleRepository
import com.zenlaeth.sirioitalia.MainActivity
import com.zenlaeth.sirioitalia.R

class ArticleAdapter(
    private val context: MainActivity,
    private val articleList: List<ArticleModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    // boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val articleImage = view.findViewById<ImageView>(R.id.image_item)
        val articleName:TextView? = view.findViewById(R.id.name_item)
        val articleDescription:TextView? = view.findViewById(R.id.description_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // recuperer les informations de l'article
        val currentArticle = articleList[position]

        // recuperer le repository
        val repo = ArticleRepository()

        // utiliser glide pour recuperer l'image à partir de son lien -> composant
        Glide.with(context).load(Uri.parse(currentArticle.imageUrl)).into(holder.articleImage)

        // mettre à jour le nom de l'article
        holder.articleName?.text = currentArticle.name

        // mettre à jour la description de l'article
        holder.articleDescription?.text = currentArticle.description

        // mettre à jour l'objet article
        repo.updateArticle(currentArticle)
    }

    override fun getItemCount(): Int = articleList.size

}