package com.zenlaeth.sirioitalia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zenlaeth.sirioitalia.adapter.PaymentAdapter
import com.zenlaeth.sirioitalia.adapter.SettingsAdapter

class PaymentActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment)

        val recyclerView = findViewById<RecyclerView>(R.id.paymentRV)
        val adapter = PaymentAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : PaymentAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                /*Toast.makeText(this@PaymentActivity, "You've clicked on no $position", Toast.LENGTH_SHORT).show()*/
                if (position == 0) {
                    val intent = Intent(this@PaymentActivity, CardPaymentActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }
}