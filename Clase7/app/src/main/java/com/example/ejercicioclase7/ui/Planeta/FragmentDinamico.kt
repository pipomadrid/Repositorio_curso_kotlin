package com.example.ejercicioclase7.ui.Planeta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicioclase7.databinding.FragmentDinamicoBinding

private const val PRIMERO: String = "nombre"
private const val SEGUNDO :String = "imagen"

class FragmentDinamico : Fragment() {

    private lateinit var binding: FragmentDinamicoBinding

    private lateinit var primero: String
    private lateinit var segundo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments.let {
            primero = it!!.getString(NOMBRE)!!
            segundo = it.getString(IMAGEN)!!

        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentDinamicoBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    companion object {
        @JvmStatic
                /* fun newInstance(nombre: String, imagen: String) =
                         PlanetaFragment().apply { //AÑADEME INFORMACIÓN
                             //AÑADE ARGUMENTOS QUE SE PODRÁN USAR EN EL FRAGMENTO
                             arguments = Bundle().apply { //AÑADAME INFORMACIÓN AL ARGUMENTS
                                 //MAPA STRING, V
                                 putString(NOMBRE, nombre)
                                 putString(IMAGEN, imagen)
                             }
                         }*/

        fun newInstance(primero: String, segundo: String) =
                FragmentDinamico().apply { //AÑADEME INFORMACIÓN
                    //AÑADE ARGUMENTOS QUE SE PODRÁN USAR EN EL FRAGMENTO
                    arguments = Bundle().apply { //AÑADAME INFORMACIÓN AL ARGUMENTS
                        //MAPA STRING, V
                        putString(PRIMERO, primero)
                        putString(SEGUNDO, segundo)
                    }
                }


    }
}