package com.zenlaeth.sirioitalia.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.*
import com.zenlaeth.sirioitalia.activity.*
import com.zenlaeth.sirioitalia.adapter.SettingsAdapter

class SettingsFragment(private val context: HomeActivity) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater?.inflate(R.layout.settings, container, false)

        // recuperer recycler view
        val settingsRecyclerView = view.findViewById<RecyclerView>(R.id.settingsRV)
        settingsRecyclerView.adapter = SettingsAdapter(object : SettingsAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 0) {
                    requireActivity().run{
                        startActivity(Intent(this, SettingsProfileActivity::class.java))
                    }
                }
                if (position == 1) {
                    requireActivity().run{
                        startActivity(Intent(this, SettingsOrderActivity::class.java))
                    }
                }
                if (position == 2) {
                    requireActivity().run{
                        startActivity(Intent(this, SettingsAddressActivity::class.java))
                    }
                }
                if (position == 3) {
                    requireActivity().run{
                        startActivity(Intent(this, SettingsPaymentActivity::class.java))
                    }
                }
            }
        })
        settingsRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}