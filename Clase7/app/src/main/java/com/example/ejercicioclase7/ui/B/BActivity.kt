package com.example.ejercicioclase7.ui.B

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicioclase7.databinding.ActivityBBinding


class BActivity : AppCompatActivity() {

    private lateinit var Binding: ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityBBinding.inflate(layoutInflater)
        val view =Binding.root
        setContentView(view)


        val boton = intent.extras!!.getInt("BOTON_PULSADO")

        val fragment = BFragment.newInstance(boton) // construimos el fragment b con el argumento neceario del newInstance
        val manager = supportFragmentManager // necesitamos el fragmentmanager para realizar la transacción
        val transaction =manager!!.beginTransaction()
        transaction.replace(Binding.activityBFrameLayout.id,fragment) // reemplazamos el framelyout por el fragmento B
        transaction.commit() // confirmamos los cambios de la transacción

    }

}