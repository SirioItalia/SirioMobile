package com.zenlaeth.sirioitalia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var loginB = findViewById<Button>(R.id.loginBSignUp)
        loginB.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, HomeActivity::class.java)
            this.startActivity(intent);
        }

        var AccountTv = findViewById<TextView>(R.id.AccountTvSignUp)
        AccountTv.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, SignInActivity::class.java)
            this.startActivity(intent);
        }
    }
}