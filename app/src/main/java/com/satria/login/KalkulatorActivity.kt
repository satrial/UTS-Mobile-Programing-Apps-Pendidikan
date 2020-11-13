package com.satria.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class KalkulatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        val txtNumber1 = findViewById<EditText>(R.id.txtNumber1)
        val txtNumber2 = findViewById<EditText>(R.id.txtNumber2)
        val txtHasil = findViewById<EditText>(R.id.txtHasil)
        val btnKembali = findViewById<Button>(R.id.btn_kembali)

        val btnKurangi = findViewById<Button>(R.id.btnKurangi)
        btnKurangi.setOnClickListener {
            if (txtNumber1.text.toString().isEmpty() || txtNumber2.text.toString().isEmpty()) {
                txtNumber1.setError("Semua input harus diisi!")
            } else {
                val a = txtNumber1.text.toString().toDouble()
                val b = txtNumber2.text.toString().toDouble()
                val c = this.kurang(a, b)
                txtHasil.setText(c.toString())
            }
        }
        btnKembali.setOnClickListener {
            onBackPressed()
        }
    }
    fun kurang(a: Double, b: Double): Double {
        return a - b
    }
}