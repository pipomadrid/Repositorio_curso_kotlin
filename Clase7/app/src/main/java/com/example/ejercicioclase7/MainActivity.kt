package com.example.ejercicioclase7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicioclase7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding //usamos para vincular elementos del layout con el código
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //usamos para vincular elementos del layout con el código
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.mainBtLogin.setOnClickListener{
            if(binding.mainTiePassword.text.isNullOrBlank()){ // Comprobamos que en el edit text del password no esté vacio
                binding.mainTilPassword.error=getString(R.string.error_blank_password) // ponemos mensaje de error obtenido desde los strings
            }
            else{
                binding.mainTilPassword.error="" // si no está vacio, eliminamos el mensaje de error
                binding.mainTilPassword.refreshErrorIconDrawableState() //quita el estado de error
            }
        }

        binding.mainBtRegistro.setOnClickListener {


        }


    }
}