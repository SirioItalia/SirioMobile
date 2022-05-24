package com.zenlaeth.sirioitalia.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.CartActivity
import com.zenlaeth.sirioitalia.HomeActivity
import com.zenlaeth.sirioitalia.R
import com.zenlaeth.sirioitalia.ShipToActivity
import com.zenlaeth.sirioitalia.adapter.ArticleAdapter
import com.zenlaeth.sirioitalia.api.ApiService
import com.zenlaeth.sirioitalia.api.FurnitureModel
import com.zenlaeth.sirioitalia.api.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater?.inflate(R.layout.cart, container, false)
        val checkB = view.findViewById<Button>(R.id.checkBCart)
        checkB.setOnClickListener {
            // Handler code here.
            val intent = Intent(activity, ShipToActivity::class.java)
            activity?.startActivity(intent);
        }

        // charger api
        val vRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getFurnitures()

        call.enqueue(object : Callback<MutableList<FurnitureModel>> {
            override fun onResponse(call: Call<MutableList<FurnitureModel>>, response: Response<MutableList<FurnitureModel>>) {
                if(response.isSuccessful){
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

        return view;
    }
    /*override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater?.inflate(R.layout.cart, container, false)
        val checkB = view.findViewById<Button>(R.id.checkBCart)
        checkB.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, ShipToActivity::class.java)
            this.startActivity(intent);
        }
        return view;
    }*/
}