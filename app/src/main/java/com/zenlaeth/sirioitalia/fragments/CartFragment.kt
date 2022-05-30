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
import com.zenlaeth.sirioitalia.activity.HomeActivity
import com.zenlaeth.sirioitalia.R
import com.zenlaeth.sirioitalia.activity.ShipToActivity
import com.zenlaeth.sirioitalia.adapter.CartAdapter
import com.zenlaeth.sirioitalia.api.ApiService
import com.zenlaeth.sirioitalia.api.ServiceGenerator
import com.zenlaeth.sirioitalia.models.CartModel
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
        val call = serviceGenerator.getCarts()

        call.enqueue(object : Callback<MutableList<CartModel>> {
            override fun onResponse(call: Call<MutableList<CartModel>>, response: Response<MutableList<CartModel>>) {
                if(response.isSuccessful){
                    vRecyclerView.apply {
                        vRecyclerView.adapter = CartAdapter(context as HomeActivity, response.body()!!, R.layout.cart_item_vertical)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<CartModel>>, t: Throwable) {
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