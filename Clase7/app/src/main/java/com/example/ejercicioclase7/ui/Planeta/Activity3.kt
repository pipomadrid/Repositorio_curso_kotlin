package com.example.ejercicioclase7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicioclase7.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {

    private lateinit var binding:Activity3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val fragmentManager = supportFragmentManager  // controlador de fragemntos dinámicos

        binding.btnAdd.setOnClickListener{

            // el control de fragmentos dinámicos se realiza con transacciones
            val transantion = fragmentManager.beginTransaction()
            val fragment = FragmentDinamico.newInstance("hola","que tal")
            transantion.add(binding.dinamicoLl.id, fragment)
            transantion.addToBackStack(null) // añadimos el fragment a la pila para poder volver a ella
            transantion.commit()
        }

        binding.btnReplace.setOnClickListener{

            // el control de fragmentos dinámicos se realiza con transacciones
            val transantion = fragmentManager.beginTransaction()
            val fragment = pruebaFragment.newInstance("hola","que tal")
            transantion.replace(binding.dinamicoLl.id, fragment)
            transantion.addToBackStack(null) // añadimos el fragment a la pila para poder volver a ella
            transantion.commit()
        }


    }



}


