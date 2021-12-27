package com.zenlaeth.sirioitalia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.ArticleModel
import com.zenlaeth.sirioitalia.ArticleRepository.Singleton.articleList
import com.zenlaeth.sirioitalia.MainActivity
import com.zenlaeth.sirioitalia.R
import com.zenlaeth.sirioitalia.adapter.ArticleAdapter
import com.zenlaeth.sirioitalia.adapter.ArticleItemDecoration

class HomeFragment(private val context: MainActivity) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater?.inflate(R.layout.fragment_home, container, false)

        // recuperer le RecycleView
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = ArticleAdapter(context, articleList, R.layout.item_horizontal_article)

        // recuperer le second RecycleView
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = ArticleAdapter(context ,articleList, R.layout.item_vertical_article)
        verticalRecyclerView.addItemDecoration(ArticleItemDecoration())

        return view
    }

}