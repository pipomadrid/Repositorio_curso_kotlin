package com.example.ejercicioclase7.ui.B

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicioclase7.R
import com.example.ejercicioclase7.databinding.ActivityABinding


class BFragment : Fragment() {

    private var Binding:ActivityABinding?= null  // creamos el binding de froma distinta a los fragments del planeta
    // el profe dijo que esta forma sigue los estándares de google
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Binding = ActivityABinding.inflate(inflater,container,false) // esto cambia tb
        val view =Binding!!.root
        return view
    }
    override fun onDestroyView(){
        super.onDestroyView()
        Binding=null // al destruir la aplicacion limpiamos el binding

    }
}