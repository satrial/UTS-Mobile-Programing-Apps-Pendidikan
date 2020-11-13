package com.satria.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.satria.login.helper.Constant
import com.satria.login.helper.PreferencesHelper
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_user.*

class DashboardActivity : AppCompatActivity() {

    lateinit var  sharedPreferences: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        sharedPreferences = PreferencesHelper(this)

        textUsername.text = sharedPreferences.getString( Constant.PREF_USERNAME)

        imgExit.setOnClickListener {
            sharedPreferences.clear()
            showMessage("Keluar")
            moveIntent()
        }

        imgberita.setOnClickListener({
            startActivity(Intent(this, BeritaActivity::class.java))
            showMessage("Ini adalah Halaman Berita")
        })
        imgProfile.setOnClickListener({
            startActivity(Intent(this, ProfileActivity::class.java))
            showMessage("Ini adalah Halaman Profile")
        })


        ImgKalkulator.setOnClickListener({
            startActivity(Intent(this, KalkulatorActivity::class.java))
            showMessage("Ini adalah Halaman Kalkulator")
        })
    }
    private fun showMessage(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
    private  fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}