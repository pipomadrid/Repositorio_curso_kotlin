package com.example.ejercicioclase7

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicioclase7.databinding.FragmentPlanetaBinding

//CONSTANTES
val NOMBRE = "nombre"
val IMAGEN = "imagen"

class PlanetaFragment : Fragment() {

    //3- Crear variable de tipo listener
    var listener:PlanetaListener?=null

    private lateinit var binding:FragmentPlanetaBinding
    private lateinit var nombre:String
    private lateinit var imagen:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtenemos los argumentos mediante let y bundle
        // el let  develve un valor en caso de que exista , compruba que no sea nulo
         arguments?.let{
             nombre = it.getString(NOMBRE)!!
             imagen= it.getString(IMAGEN)!!

         }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentPlanetaBinding.inflate(layoutInflater)
        val view= binding.root
        binding.boton.setOnClickListener{
            val planeta = binding.fragmentPlanetaEt.text.toString()
            listener?.guardarPlaneta(planeta)
            binding.fragmentPlanetaEt.text.clear()

        }
        return view
    }

    // PASOS CREACION LISTENER
    // 1-Creamos la interfaz con su método  y la implementamos en la activity,
    // en este caso PlanetaActivity (el segundo paso continúa en dicha activity)
    interface PlanetaListener {
        fun guardarPlaneta(nombre: String)
    }

    // 4- Vinculamos el fragment con la actividad mediante el listener
    override fun onAttach(context: Context) { // este contexto hace referencia a la acitivity que estamos creando
        super.onAttach(context)
        listener = context as PlanetaListener // hacemos cast para obtener la función guardarplaneta y poder usarla
    }

    companion object{
        @JvmStatic
        fun newInstance(nombre:String,imagen:String)=
            PlanetaFragment().apply {
                //usamos el patrón builder con apply
                //añade argumentos que se podrán usar en el fragmento creando un bundle y asigandoselo a los mismos
                arguments = Bundle().apply {
                    // MAPA STRING, VALOR
                    putString(NOMBRE,nombre)
                    putString(IMAGEN,imagen)

                }
            }

    }
}