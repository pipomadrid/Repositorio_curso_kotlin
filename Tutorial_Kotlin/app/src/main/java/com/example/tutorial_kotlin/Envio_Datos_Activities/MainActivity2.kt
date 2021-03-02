package com.example.tutorial_kotlin.Envio_Datos_Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tutorial_kotlin.R
 private  val TAG="Activity2"  // PAra usar en el LogCat


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        // Para recibir el extra usamos
        /*val extra=intent.extras
        val numero= extra?.get("numero")
        Log.d(TAG, numero.toString())*/


    }
}