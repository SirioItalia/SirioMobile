package com.zenlaeth.sirioitalia.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zenlaeth.sirioitalia.R

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart)

/*        var checkB = findViewById<Button>(R.id.checkBCart)
        checkB.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, ShipToActivity::class.java)
            this.startActivity(intent);
        }*/
    }
}