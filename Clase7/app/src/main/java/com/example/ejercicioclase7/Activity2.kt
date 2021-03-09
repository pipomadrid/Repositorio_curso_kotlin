package com.example.ejercicioclase7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.example.ejercicioclase7.databinding.Activity2Binding
import com.google.android.material.textfield.TextInputEditText


class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding //usamos para vincular elementos del layout con el código

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =Activity2Binding .inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        var nombre=binding.activity2TieNombre
        var email=binding.activity2TieEmail
        var contra=binding.activity2TieContra
        var repetirContra=binding.activity2TieRepitaContra


        nombre.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) binding.activity2TilNombre.error = ""
        }
        email.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) binding.activity2TilEmail.error = ""
        }
       contra.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) binding.activity2TilContra.error = ""
        }
       repetirContra.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) binding.activity2TilRepitaContra.error = ""
        }

        nombre.setOnClickListener{
            val text=it as TextInputEditText
            if(text.text!!.isNotEmpty()){

                binding.activity2TilNombre.error=""
            }
        }

        email.setOnClickListener{
            val text=it as TextInputEditText
            if(text.text!!.isNotEmpty()){

                binding.activity2TilEmail.error=""
            }
        }

        contra.setOnClickListener{
            val text=it as TextInputEditText
            if(text.text!!.isNotEmpty()){

                binding.activity2TilContra.error=""
            }
        }

        repetirContra.setOnClickListener{
            val text=it as TextInputEditText
            if(text.text!!.isNotEmpty()){

                binding.activity2TilRepitaContra.error=""
            }
        }

        repetirContra.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                binding.activity2BtnRegistrar.performClick()
                true
            }
            false
        }


        binding.activity2BtnCancelar.setOnClickListener{
             val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        binding.activity2BtnRegistrar.setOnClickListener {
           val attr= listOf(nombre,email,contra,repetirContra)
            var error=false
            attr.forEach{
                if(it.obtenerTexto().isBlank()){
                    error=true
                    when(it.id){
                        R.id.activity2TieNombre ->{
                            binding.activity2TilNombre.error="Debes introducir tu nombre completo"
                        }
                        R.id.activity2TilEmail ->{
                            binding.activity2TilEmail.error="Debes introducir un email"
                        }
                    }
                }
            }

        }
    }
    fun TextInputEditText.obtenerTexto():String{

        return text.toString()
    }
}