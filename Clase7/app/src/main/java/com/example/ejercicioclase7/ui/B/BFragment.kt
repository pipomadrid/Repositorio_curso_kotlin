package com.example.ejercicioclase7.ui.B

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicioclase7.R
import com.example.ejercicioclase7.databinding.FragmentBBinding

const val param1= "BOTON_PULSADO"
class BFragment : Fragment() {

    private var Binding:FragmentBBinding?= null  // creamos el binding de froma distinta a los fragments del planeta
    // el profe dijo que esta forma sigue los estándares de google
        private var botonPulsado:Int  = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let{
            botonPulsado = it!!.getInt(param1)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Binding = FragmentBBinding.inflate(inflater,container,false) // esto cambia tb
        val view =Binding!!.root

        // al pulsar el botón de la actividad A crea un nuevo fragment y rellena el text view con el botonPulsado obtenido en arguments
        Binding!!.fragmentBTv.text = getString(R.string.tv_fragment_b,botonPulsado)  //hemos creado un string que puea recibir parámetros en values
        return view
    }
    override fun onDestroyView(){
        super.onDestroyView()
        Binding=null // al destruir la aplicacion limpiamos el binding

    }

    // usamos el new instance para pasar el boton pulsado del fragmento A al fragmento B
    //seria como crear un constructo al que se le tenga que pasar el argumento para luego en onCreate obtenerlo y poder usarlo
    companion object{
    @JvmStatic
        fun newInstance(boton:Int) =
            BFragment().apply {
                arguments = Bundle().apply {
                    putInt(param1,boton)
                }
            }

    }
}