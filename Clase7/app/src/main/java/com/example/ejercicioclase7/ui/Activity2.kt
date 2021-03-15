package com.example.ejercicioclase7.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.example.ejercicioclase7.R
import com.example.ejercicioclase7.databinding.Activity2Binding
import com.google.android.material.textfield.TextInputEditText


class Activity2 : AppCompatActivity() {
    private lateinit var binding: Activity2Binding //usamos para vincular elementos del layout del activity2 con el código

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =Activity2Binding .inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        // asignamos variables a los binding para acortar código
        var nombre=binding.activity2TieNombre
        var email=binding.activity2TieEmail
        var contra=binding.activity2TieContra
        var repetirContra=binding.activity2TieRepitaContra



        // cuando los textInput reciben el foco  se limpia el error
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


        // cuando se hace Click en los textinput y hay texto se limpia el error
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

        // El ime se define en el xml del layout , repetircontra está a la escucha y cuando recibe el IME
        // adecuado realiza la acción que le indiquemos
        // con el actionId comprobamos que accion estamos recibiendo
        repetirContra.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                binding.activity2BtnRegistrar.performClick() // simula el click sobre el botón indicado
                true // tenemos que devolver booleano pero no lo usamos
            }
            false
        }


        binding.activity2BtnCancelar.setOnClickListener{
            setResult(AppCompatActivity.RESULT_CANCELED)
            finish()
        }

        // al darle a registrar creamos una lista de TextInputEditText  y creamos un bucle para comprobar
        // si hay errores y de ser así los especificamos
        binding.activity2BtnRegistrar.setOnClickListener {
            val attr= listOf(nombre,email,contra,repetirContra)
            var error=false
            attr.forEach {
                if (it.obtenerTexto().isBlank()) {
                    error = true
                    when (it.id) {
                        R.id.activity2TieNombre -> {
                            binding.activity2TilNombre.error = "Debes introducir tu nombre completo"
                        }
                        R.id.activity2TieEmail -> {
                            binding.activity2TilEmail.error = "Debes introducir un email"
                        }
                        R.id.activity2TieContra -> {
                            binding.activity2TilContra.error = "Debes introducir un email"
                        }
                        R.id.activity2TieRepitaContra -> {
                            binding.activity2TilRepitaContra.error = "Debes introducir un email"
                        }
                    }
                }
            }
            if (error)
                return@setOnClickListener //  preguntar profesor
            // si la contraseña es menor que 5 ponemos mensaje de error
            if (contra.obtenerTexto().length < 5) {
                binding.activity2TilContra.error = "La contraseña debe de tener como mínimo 5 letras"
                return@setOnClickListener
            }
            //si la contraseña segunda es diferente de la primera lanza un error
            if (!contra.obtenerTexto().equals(repetirContra.obtenerTexto())) {
                binding.activity2TilContra.error = "Las contraseñas no coinciden"
                binding.activity2TilRepitaContra.error = "Las contraseñas no coinciden"
                return@setOnClickListener
            }

            val intent = Intent()
            intent.putExtra("email", email.obtenerTexto())
            intent.putExtra("password", contra.obtenerTexto())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

 // función que relizamos para escribir menos código , extendemos la funcionalidad de la clase TextinputEditText
    //  se llaman extensions
    fun TextInputEditText.obtenerTexto():String{

        return text.toString()
    }
}