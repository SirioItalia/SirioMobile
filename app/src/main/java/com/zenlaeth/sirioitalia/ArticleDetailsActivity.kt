package com.zenlaeth.sirioitalia

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.adapter.ArticleAdapter
import com.zenlaeth.sirioitalia.adapter.ArticleDetailsAdapter

class ArticleDetailsActivity() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.article_details)

        /*val image = intent.getStringExtra(ArticleAdapter.ViewHolder.articleImageKey)*/
        val articleImageIv: ImageView = findViewById(R.id.article_image_item)
        val articleNameTv: TextView = findViewById(R.id.article_detail_name)
        val articleDescriptionTv: TextView = findViewById(R.id.article_detail_description)
        val articlePriceTv: TextView = findViewById(R.id.article_detail_price)
        val articleDimensionTv: TextView = findViewById(R.id.article_detail_dimension)
        val articleWeightTv: TextView = findViewById(R.id.article_detail_weight)
        val colorRecyclerView = findViewById<RecyclerView>(R.id.article_colors_recycler_view)


        val bundle: Bundle? = intent.extras
        val articleImageId = bundle!!.getInt(ArticleAdapter.ViewHolder.articleImageKey)
        val articleName = intent.getStringExtra(ArticleAdapter.ViewHolder.articleNameKey)
        val articleDescription = intent.getStringExtra(ArticleAdapter.ViewHolder.articleDescriptionKey)
        val articlePrice = intent.getStringExtra(ArticleAdapter.ViewHolder.articlePriceKey)
        val articleDimension = intent.getStringExtra(ArticleAdapter.ViewHolder.articleDimensionKey)
        val articleWeight = intent.getStringExtra(ArticleAdapter.ViewHolder.articleWeightKey)
        val articleColorsName = intent.getStringExtra(ArticleAdapter.ViewHolder.articleColorsNameKey)
        val articleColorsHexa = intent.getStringExtra(ArticleAdapter.ViewHolder.articleColorsHexaKey)

        colorRecyclerView.apply {
            colorRecyclerView.adapter = ArticleDetailsAdapter(context as ArticleDetailsActivity, articleColorsHexa, articleColorsName)
        }

        articleImageIv.setImageResource(articleImageId)
        articleNameTv.text = articleName
        articleDescriptionTv.text = articleDescription
        articlePriceTv.text = articlePrice
        articleDimensionTv.text = articleDimension
        articleWeightTv.text = articleWeight
        /*val articleImageItem = findViewById<ImageView>(R.id.article_image_item)
*/
    }
}