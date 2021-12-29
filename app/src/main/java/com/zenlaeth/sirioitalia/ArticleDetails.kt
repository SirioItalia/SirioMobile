package com.zenlaeth.sirioitalia

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zenlaeth.sirioitalia.adapter.ArticleAdapter

class ArticleDetails() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.article_details)
        val Picture = getIntent().getStringExtra("picture")
    }
}