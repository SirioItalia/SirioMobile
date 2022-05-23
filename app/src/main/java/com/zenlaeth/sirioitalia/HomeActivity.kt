package com.zenlaeth.sirioitalia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zenlaeth.sirioitalia.adapter.ArticleAdapter
import com.zenlaeth.sirioitalia.api.ApiService
import com.zenlaeth.sirioitalia.api.FurnitureModel
import com.zenlaeth.sirioitalia.api.ServiceGenerator
import com.zenlaeth.sirioitalia.fragments.CartFragment
import com.zenlaeth.sirioitalia.fragments.ExplorerFragment
import com.zenlaeth.sirioitalia.fragments.HomeFragment
import com.zenlaeth.sirioitalia.fragments.SettingsFragment
import com.zenlaeth.sirioitalia.repository.ArticleRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadFragment(HomeFragment(this), R.string.home_page_title)

        // importer la bottomNavigationView
        val navigationView = findViewById<BottomNavigationView>(R.id.navigation_view)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.home_page -> {
                    loadFragment(HomeFragment(this), R.string.home_page_title)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.explorer_page -> {
                    loadFragment(ExplorerFragment(this), R.string.explorer_page_title)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.cart_page -> {
                    loadFragment(CartFragment(), R.string.cart_page_title)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.settings_page -> {
                    loadFragment(SettingsFragment(this), R.string.settings_page_title)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment, string: Int) {
        // charger notre repository
//        val repo = ArticleRepository()

        // actualiser le titre de la page
        findViewById<TextView>(R.id.page_title).text = resources.getString(string)

        // mettre à jour la liste des articles
//        repo.updateData {
            // injecter le fragment dans notre boîte (fragment_container)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
//        }
    }
}