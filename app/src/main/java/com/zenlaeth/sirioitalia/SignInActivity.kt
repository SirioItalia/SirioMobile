package com.zenlaeth.sirioitalia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_activity)

        var loginB = findViewById<Button>(R.id.loginBSignIn)
        loginB.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, HomeActivity::class.java)
            this.startActivity(intent);
        }

        var noAccountTv = findViewById<TextView>(R.id.noAccountTvSignIn)
        noAccountTv.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, SignUpActivity::class.java)
            this.startActivity(intent);
            finish()
        }
    }
}