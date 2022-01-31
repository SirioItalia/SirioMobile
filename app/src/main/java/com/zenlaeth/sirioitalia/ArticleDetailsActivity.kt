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
        val imageView: ImageView = findViewById(R.id.article_image_item)
        val textView: TextView = findViewById(R.id.article_detail_description)
        val textView2: TextView = findViewById(R.id.article_detail_name)

        val bundle: Bundle = intent.extras!!
        val articleImageKey: Int = bundle.getInt(ArticleAdapter.ViewHolder.articleImageKey)
        val articleDescription = intent.getStringExtra(ArticleAdapter.ViewHolder.articleDescriptionKey)
        val articleName = intent.getStringExtra(ArticleAdapter.ViewHolder.articleNameKey)

        imageView.setImageResource(articleImageKey)
        textView.text = articleDescription
        textView2.text = articleName
        /*val articleImageItem = findViewById<ImageView>(R.id.article_image_item)
*/
    }
}