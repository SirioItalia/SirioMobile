package com.zenlaeth.sirioitalia

import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zenlaeth.sirioitalia.adapter.ArticleAdapter

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

        val bundle: Bundle? = intent.extras
        val articleImageId = bundle!!.getInt(ArticleAdapter.ViewHolder.articleImageKey)
        val articleName = intent.getStringExtra(ArticleAdapter.ViewHolder.articleNameKey)
        val articleDescription = intent.getStringExtra(ArticleAdapter.ViewHolder.articleDescriptionKey)
        val articlePrice = intent.getStringExtra(ArticleAdapter.ViewHolder.articlePriceKey)
        val articleDimension = intent.getStringExtra(ArticleAdapter.ViewHolder.articleDimensionKey)
        val articleWeight = intent.getStringExtra(ArticleAdapter.ViewHolder.articleWeightKey)

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