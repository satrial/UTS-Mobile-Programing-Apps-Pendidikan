package com.satria.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.satria.login.helper.Constant
import com.satria.login.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    lateinit var  sharedPreferences: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sharedPreferences = PreferencesHelper(this)

        textUsername.text = sharedPreferences.getString( Constant.PREF_USERNAME)

        buttonLogout.setOnClickListener {
            sharedPreferences.clear()
            showMessage("Keluar")
            moveIntent()
        }
    }
    private  fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


    private fun showMessage(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}