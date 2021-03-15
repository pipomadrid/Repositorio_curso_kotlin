package com.example.ejercicioclase7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicioclase7.databinding.ActivityPlanetaBinding

class PlanetaActivity : AppCompatActivity(), PlanetaFragment.PlanetaListener{


    private lateinit var binding :ActivityPlanetaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityPlanetaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnToActivity3.setOnClickListener{
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)

        }


    }
// 2-Esta clase implementa el listener del fragmento(ver clase arriba)
// y sobreescribe la función para darle funcionalidad(3 paso en fragment)
    override fun guardarPlaneta(nombre: String) {
        // codigo a realizar cuando el listener emita un valor
        var texto= binding.textview.text.toString()  // almacena lo que hay en el textview
        texto += "$nombre \n"  // añadimos el texto pasado por prámetro a la función guardarplaneta
        binding.textview.text = texto   // ponemos el resultado de nuevo en el textView

    }

}