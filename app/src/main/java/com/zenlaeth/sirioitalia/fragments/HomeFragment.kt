package com.zenlaeth.sirioitalia.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.activity.HomeActivity
import com.zenlaeth.sirioitalia.R
import com.zenlaeth.sirioitalia.adapter.ArticleAdapter
import com.zenlaeth.sirioitalia.api.ApiService
import com.zenlaeth.sirioitalia.api.FurnitureModel
import com.zenlaeth.sirioitalia.api.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment(private val context: HomeActivity) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater?.inflate(R.layout.fragment_home, container, false)

        // charger api
        val hRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        val vRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getFurnitures()

        call.enqueue(object : Callback<MutableList<FurnitureModel>> {
            override fun onResponse(call: Call<MutableList<FurnitureModel>>, response: Response<MutableList<FurnitureModel>>) {
                if(response.isSuccessful){
                    hRecyclerView.apply {
                        hRecyclerView.adapter = ArticleAdapter(context as HomeActivity, response.body()!!, R.layout.article_item_horizontal)
                    }
                    vRecyclerView.apply {
                        vRecyclerView.adapter = ArticleAdapter(context as HomeActivity, response.body()!!, R.layout.article_item_vertical)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<FurnitureModel>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }

        })

        return view
    }

}