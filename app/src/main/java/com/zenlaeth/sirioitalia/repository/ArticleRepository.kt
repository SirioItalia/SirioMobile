package com.zenlaeth.sirioitalia.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.zenlaeth.sirioitalia.ArticleModel
import com.zenlaeth.sirioitalia.api.FurnitureModel
import com.zenlaeth.sirioitalia.repository.ArticleRepository.Singleton.articleList

class ArticleRepository {
    object Singleton {
        // se connecter à la référence "article"
//        val databaseRef = FirebaseDatabase.getInstance().getReference("articles");

        // créer une liste qui va contenir nos plantes
        val articleList = arrayListOf<FurnitureModel>()
    }

//    fun updateData(callback: () -> Unit) {
//        fun onDataChange(snapshot: DataSnapshot) {
//            // retirer les anciennes
//            articleList.clear()
//            // recolter la liste
//            for (ds in snapshot.children) {
//                // construire un objet article
//                val article = ds.getValue(FurnitureModel::class.java)
//
//                // verifier que l'article n'est pas null
//                if (article != null) {
//                    articleList.add(article)
//                }
//            }
//            // actionner le callback
//            callback()
//        }
//
//        fun onCancelled(p0: DatabaseError) {}
//    }

    // mettre à jour un article dans la bdd
//    fun updateArticle(article: ArticleModel) = databaseRef.child(article.id).setValue(article)
}