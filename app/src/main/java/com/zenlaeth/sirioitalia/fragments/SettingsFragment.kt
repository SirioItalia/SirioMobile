package com.zenlaeth.sirioitalia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.HomeActivity
import com.zenlaeth.sirioitalia.R
import com.zenlaeth.sirioitalia.adapter.SettingsAdapter

class SettingsFragment(private val context: HomeActivity) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater?.inflate(R.layout.settings, container, false)

        // recuperer recycler view
        val settingsRecyclerView = view.findViewById<RecyclerView>(R.id.settingsRV)
        settingsRecyclerView.adapter = SettingsAdapter()
        settingsRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }
}