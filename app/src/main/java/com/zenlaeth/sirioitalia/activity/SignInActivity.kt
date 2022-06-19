package com.zenlaeth.sirioitalia.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.zenlaeth.sirioitalia.R
import com.zenlaeth.sirioitalia.api.ApiService
import com.zenlaeth.sirioitalia.api.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Context
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject
import org.json.JSONTokener


class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_activity)
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        Log.e("error", "User id saved : " + sharedPreferences.getInt("ID_KEY", 0).toString())

//        loadData()

        var loginB = findViewById<Button>(R.id.loginBSignIn)
        loginB.setOnClickListener {

            val email = findViewById<TextView>(R.id.emailEtSignIn).text.toString().trim()
            val password = findViewById<TextView>(R.id.passwordEtSignIn).text.toString().trim()
            var registerList = listOf(email, password)
            for(field in registerList){
                if(field.isEmpty()){
                    if(field == email) {
                        findViewById<TextView>(R.id.emailEtSignIn).error = "Email required"
                        findViewById<TextView>(R.id.emailEtSignIn).requestFocus()
                    }
                    if(field == password) {
                        findViewById<TextView>(R.id.passwordEtSignIn).error = "Password required"
                        findViewById<TextView>(R.id.passwordEtSignIn).requestFocus()
                        return@setOnClickListener
                    }
                }
            }

            val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)

            var call = serviceGenerator.loginUser(email, password)
            val intent = Intent(this, HomeActivity::class.java)

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if(response.code() == 200) {
                        var responseString = response.body()?.string()
                        val responseBody = JSONTokener(responseString).nextValue() as JSONObject
                        saveData(responseBody.getString("sessionUserId").toInt())
                        Toast.makeText(applicationContext, "Login successful!", Toast.LENGTH_LONG).show()

                        this@SignInActivity.startActivity(intent);
                    }
                    if(response.code() == 401) {
                        Toast.makeText(applicationContext, "Email or password incorrect!", Toast.LENGTH_LONG).show()
                        Log.e("error", "bad")
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(applicationContext, "Email or password incorrect!", Toast.LENGTH_LONG).show()
                    Log.e("error", "bad")
                }
            })
        }

        var noAccountTv = findViewById<TextView>(R.id.noAccountTvSignIn)
        noAccountTv.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, SignUpActivity::class.java)
            this.startActivity(intent);
            finish()
        }
    }

    private fun saveData(id: Int) {
        val insertedInt:Int = id
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply() {
            putInt("ID_KEY", insertedInt)
        }.apply()
        Log.e("error", "User id saved : " + sharedPreferences.getInt("ID_KEY", 0).toString())
    }

//    private fun loadData() {
//        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//        val savedEmail:String? = sharedPreferences.getString("EMAIL_KEY", null)
//        val continueD: TextView = findViewById(R.id.continueTvSignIn)
//        continueD.text = savedEmail
//    }

    //        sharedPreferences.edit().remove("EMAIL_KEY").commit();
}