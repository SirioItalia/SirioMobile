package com.zenlaeth.sirioitalia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zenlaeth.sirioitalia.fragments.HomeFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // charger notre repository
        val repo = ArticleRepository()

        // mettre à jour la liste des articles
        repo.updateData {
            // injecter le fragment dans notre boîte (fragment_container)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}