package com.zenlaeth.sirioitalia

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.zenlaeth.sirioitalia.ArticleRepository.Singleton.articleList
import com.zenlaeth.sirioitalia.ArticleRepository.Singleton.databaseRef

class ArticleRepository {
    object Singleton {
        // se connecter à la référence "article"
        val databaseRef = FirebaseDatabase.getInstance().getReference("articles");

        // créer une liste qui va contenir nos plantes
        val articleList = arrayListOf<ArticleModel>()
    }

    fun updateData(callback: () -> Unit) {
        // absorber les données depuis la databaseRef -> liste d'articles
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // retirer les anciennes
                articleList.clear()
                // recolter la liste
                for (ds in snapshot.children) {
                    // construire un objet article
                    val article = ds.getValue(ArticleModel::class.java)

                    // verifier que l'article n'est pas null
                    if (article != null) {
                        articleList.add(article)
                    }
                }
                // actionner le callback
                callback()
            }

            override fun onCancelled(p0: DatabaseError) {}

        })
    }

    // mettre à jour un article dans la bdd
    fun updateArticle(article: ArticleModel) = databaseRef.child(article.id).setValue(article)
}