package com.zenlaeth.sirioitalia.fragments

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.*
import com.zenlaeth.sirioitalia.adapter.ExplorerAdapter
import android.view.MenuInflater

class ExplorerFragment(private val context: HomeActivity) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater?.inflate(R.layout.explorer_categories, container, false)
        setHasOptionsMenu(true);

        // recuperer recycler view
        val explorerRecyclerView = view.findViewById<RecyclerView>(R.id.explorerRV)
        explorerRecyclerView.adapter = ExplorerAdapter(object : ExplorerAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                if (position == 0) {
                    requireActivity().run{
                        startActivity(Intent(this, ExplorerResultActivity::class.java))
                    }
                }
                if (position == 1) {
                    requireActivity().run{
                        startActivity(Intent(this, ExplorerResultActivity::class.java))
                    }
                }
                if (position == 2) {
                    requireActivity().run{
                        startActivity(Intent(this, ExplorerResultActivity::class.java))
                    }
                }
                if (position == 3) {
                    requireActivity().run{
                        startActivity(Intent(this, ExplorerResultActivity::class.java))
                    }
                }
            }
        })
        explorerRecyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.explorer_menu, menu)

        val manager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.search_article)
        val searchView = searchItem?.actionView as SearchView

        searchView.setSearchableInfo(manager.getSearchableInfo(requireActivity().componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("", false)
                searchItem.collapseActionView()
                Toast.makeText(activity, "Looking for $query", Toast.LENGTH_LONG).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(activity, "Looking for $newText", Toast.LENGTH_LONG).show()
                return false
            }
        })
    }
}

/*
class ExplorerFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        return inflater?.inflate(R.layout.explorer, container, false)
    }
}*/
