package com.zenlaeth.sirioitalia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.*
import com.zenlaeth.sirioitalia.api.FurnitureModel

class ArticleAdapter(
    val context: HomeActivity,
    private val articleList: List<FurnitureModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    // boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val articleImage = view.findViewById<ImageView>(R.id.image_item)
        val articleName:TextView? = view.findViewById(R.id.name_item)
        val articleDescription:TextView? = view.findViewById(R.id.description_item)
        val articlePrice:TextView? = view.findViewById(R.id.price_item)
        val articleDimension:TextView? = view.findViewById(R.id.dimension_item)
        val articleWeight:TextView? = view.findViewById(R.id.weight_item)
        val articleColorsName:TextView? = view.findViewById(R.id.colors_name_item)
        val articleColorsHexa:TextView? = view.findViewById(R.id.colors_hexa_item)

        companion object {
            val articleNameKey = "ARTICLE_NAME"
            val articleImageKey = "ARTICLE_IMAGE"
            val articleDescriptionKey = "ARTICLE_DESCRIPTION"
            val articlePriceKey = "ARTICLE_PRICE"
            val articleDimensionKey = "ARTICLE_DIMENSION"
            val articleWeightKey = "ARTICLE_WEIGHT"
            val articleColorsNameKey = "ARTICLE_NAME_COLORS"
            val articleColorsHexaKey = "ARTICLE_Hexa_COLORS"
        }
        init {
            view.setOnClickListener{
                val intent = Intent(view.context, ArticleDetailsActivity::class.java)
                intent.putExtra(articleImageKey, articleImage.toString())
                intent.putExtra(articleDescriptionKey, articleDescription?.text)
                intent.putExtra(articleNameKey, articleName?.text)
                intent.putExtra(articlePriceKey, articlePrice?.text)
                intent.putExtra(articleDimensionKey, articleDimension?.text)
                intent.putExtra(articleWeightKey, articleWeight?.text)
                intent.putExtra(articleColorsNameKey, articleColorsName?.text)
                intent.putExtra(articleColorsHexaKey, articleColorsHexa?.text)
                view.context.startActivity(intent)
            }
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
        val currentArticle = articleList[position]

        // utiliser glide pour recuperer l'image à partir de son lien -> composant
//        Glide.with(context).load(Uri.parse(currentArticle.imageUrl)).into(holder.articleImage)

        // mettre à jour champs articles
        holder.articleName?.text = currentArticle.label
        holder.articleDescription?.text = currentArticle.description
        var listDimension = mutableListOf<String>()

        listDimension.add(currentArticle.dimension.length.toString())
        listDimension.add(currentArticle.dimension.height.toString())
        listDimension.add(currentArticle.dimension.width.toString())

        holder.articleDimension?.text = listDimension.joinToString(separator=" x ")

        holder.articleWeight?.text = currentArticle.weight.toString() + "kg"

        var listPrice = mutableListOf<String>()
        var listColorName = mutableListOf<String>()
        var listColorHexa = mutableListOf<String>()

        currentArticle.items.forEach(){
            listPrice.add(it.price.toString())
            listColorName.add(it.color.label)
            listColorHexa.add(it.color.hexadecimalCode)
        }

        // price
        val min = listPrice.minOrNull() ?: 0
        val max = listPrice.maxOrNull() ?: 0
        holder.articlePrice?.text = "$min ~ $max €"

        // colors
        holder.articleColorsName?.text = listColorName.joinToString(separator="-")
        holder.articleColorsHexa?.text = listColorHexa.joinToString(separator="-")

/*        // mettre à jour l'image (intent extra)
        holder.articleImage?.drawable */
    }

    override fun getItemCount(): Int = articleList.size
}