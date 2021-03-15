package com.example.ejercicioclase7.ui.A

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicioclase7.databinding.ActivityBBinding

class AFragment : Fragment() {

    private var Binding: ActivityBBinding?= null  // creamos el binding de froma distinta a los fragments del planeta
    // el profe dijo que esta forma sigue los estándares de google
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Binding = ActivityBBinding.inflate(inflater,container,false) // esto cambia tb
        val view =Binding!!.root
        return view

    }

    override fun onDestroyView(){
        super.onDestroyView()
        Binding=null // al destruir la aplicacion limpiamos el binding

    }
}