package com.zenlaeth.sirioitalia.activity

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.R
import com.zenlaeth.sirioitalia.adapter.ArticleAdapter
import com.zenlaeth.sirioitalia.adapter.ArticleDetailsAdapter
import com.zenlaeth.sirioitalia.api.ApiService
import com.zenlaeth.sirioitalia.api.ServiceGenerator
import com.zenlaeth.sirioitalia.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
//        val articleImageId = bundle!!.getInt(ArticleAdapter.ViewHolder.articleImageKey)
        val articleItemId = intent.getStringExtra(ArticleAdapter.ViewHolder.articleIdKey)
        val articleName = intent.getStringExtra(ArticleAdapter.ViewHolder.articleNameKey)
        val articleDescription = intent.getStringExtra(ArticleAdapter.ViewHolder.articleDescriptionKey)
        val articlePrice = intent.getStringExtra(ArticleAdapter.ViewHolder.articlePriceKey)
        val articlePrices = intent.getStringExtra(ArticleAdapter.ViewHolder.articlePricesKey)
        val articleDimension = intent.getStringExtra(ArticleAdapter.ViewHolder.articleDimensionKey)
        val articleWeight = intent.getStringExtra(ArticleAdapter.ViewHolder.articleWeightKey)
        val articleColorsName = intent.getStringExtra(ArticleAdapter.ViewHolder.articleColorsNameKey)
        val articleColorsHexa = intent.getStringExtra(ArticleAdapter.ViewHolder.articleColorsHexaKey)

        colorRecyclerView.apply {
            colorRecyclerView.adapter = ArticleDetailsAdapter(object : ArticleDetailsAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
                        Log.e("error", "good")
//                    val articlesPriceList: List<String>? = articlePrices?.split("-")?.toList()
//                    articlePriceTv.text = articlesPriceList?.get(position)
                }
            }, context as ArticleDetailsActivity, articleColorsHexa, articleColorsName, articlePrices)
        }

//        articleImageIv.setImageResource(articleImageId)
        articleNameTv.text = articleName
        articleDescriptionTv.text = articleDescription
        val articlesPriceList: List<String>? = articlePrices?.split("-")?.toList()
        articlePriceTv.text = articlesPriceList?.get(0) + " €" // testCart
        articleDimensionTv.text = articleDimension
        articleWeightTv.text = articleWeight
        /*val articleImageItem = findViewById<ImageView>(R.id.article_image_item)
*/
        var loginB = findViewById<Button>(R.id.addBCart)
        loginB.setOnClickListener {
            val userId = 4 // testCart

            val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)

            var cart = NewCart(1, // testCart
                NewCartItem(articleItemId!!.toInt()),
                NewCartUser(userId)
            )

            var call = serviceGenerator.createCart(cart)

            call.enqueue(object : Callback<MutableList<NewCart>> {
                override fun onResponse(call: Call<MutableList<NewCart>>, response: Response<MutableList<NewCart>>) {
                    Toast.makeText(applicationContext, "Item added to your cart !", Toast.LENGTH_LONG).show()
                    Log.e("error", "good")
                }

                override fun onFailure(call: Call<MutableList<NewCart>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    t.message?.let { it1 -> Log.e("error", it1) }
                }
            })
        }

    }
}