package com.zenlaeth.sirioitalia.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.zenlaeth.sirioitalia.CartActivity
import com.zenlaeth.sirioitalia.HomeActivity
import com.zenlaeth.sirioitalia.R
import com.zenlaeth.sirioitalia.ShipToActivity

class CartFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater?.inflate(R.layout.cart, container, false)
        val checkB = view.findViewById<Button>(R.id.checkBCart)
        checkB.setOnClickListener {
            // Handler code here.
            val intent = Intent(activity, ShipToActivity::class.java)
            activity?.startActivity(intent);
        }
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