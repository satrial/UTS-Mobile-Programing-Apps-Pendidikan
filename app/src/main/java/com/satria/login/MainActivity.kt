package com.satria.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import com.satria.login.helper.Constant
import com.satria.login.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  sharedPreferences: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = PreferencesHelper(this)

        buttonLogin.setOnClickListener {
            if(editUsername.text.isNotEmpty() && editUsername.text.isNotEmpty()){
                saveSession(editUsername.text.toString(), editPassword.text.toString())
               showMessage("Berhasil Masuk")
                moveIntent()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (sharedPreferences.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    private  fun moveIntent(){
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    private  fun saveSession( username: String, password: String){
        sharedPreferences.put(Constant.PREF_USERNAME, username)
        sharedPreferences.put(Constant.PREF_PASSWORD, password)
        sharedPreferences.put(Constant.PREF_IS_LOGIN, true)
    }

    private fun showMessage(message: String){
   Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}