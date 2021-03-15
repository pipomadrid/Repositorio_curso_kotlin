package com.example.ejercicioclase7

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.ejercicioclase7.databinding.ActivityMainBinding
import com.example.ejercicioclase7.ui.Planeta.PlanetaActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding //usamos para vincular elementos del layout con el código
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Base_MyTheme) // nos pone el tema base de nuestra app
        //usamos para vincular elementos del layout con el código
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.mainTiePassword.setOnFocusChangeListener{ _, hasFocus ->  // Al  coger el foco , resetea el error
            if(hasFocus){
                binding.mainTilPassword.error = ""
            }

        }

        //Esta función controla la introducción del texto, al escribir texto comprueba el tamaño y si es mas de 5 elimina el error
        binding.mainTiePassword.addTextChangedListener {
            val size = it!!.length   // devuelve el tamaño del  it que devuelve la función
            if(size<5) {
                binding.mainTilPassword.error = "Carácteres $size/5"
            }
            else{

                binding.mainTilPassword.error = ""
            }


        }
        // Con esta función comprobamos el password al hacer click en el Tie
        binding.mainTiePassword.setOnClickListener {
            val textInput = it as TextInputEditText
            val size = textInput.text!!.toString().length
            if(size<5) {
                binding.mainTilPassword.error = "Carácteres $size/5"
            }
            else{

                binding.mainTilPassword.error = ""
            }
        }


        binding.mainBtLogin.setOnClickListener{
            if(binding.mainTiePassword.text.isNullOrBlank()){ // Comprobamos que en el edit text del password no esté vacio
                binding.mainTilPassword.error=getString(R.string.error_blank_password) // ponemos mensaje de error obtenido desde los strings
            }
            else{
                binding.mainTilPassword.error="" // si no está vacio, eliminamos el mensaje de error
                binding.mainTilPassword.refreshErrorIconDrawableState() //quita el estado de error
            }

            val intent= Intent(this, PlanetaActivity::class.java)
                startActivity(intent)
        }

        binding.mainBtRegistro.setOnClickListener {
        val intent= Intent(this,Activity2::class.java)
            startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

        }


    }
}