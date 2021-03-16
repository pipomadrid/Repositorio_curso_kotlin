package com.example.ejercicioclase7.ui.A

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ejercicioclase7.databinding.ActivityABinding
import com.example.ejercicioclase7.databinding.FragmentABinding
import com.example.ejercicioclase7.ui.B.BActivity
import com.example.ejercicioclase7.ui.B.BFragment

class AFragment : Fragment() {

    private var Binding: FragmentABinding?= null  // creamos el binding de froma distinta a los fragments del planeta
    // el profe dijo que esta forma sigue los estándares de google
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Binding = FragmentABinding.inflate(inflater,container,false) // esto cambia tb
        val view =Binding!!.root

        Binding!!.fragmentABoton1.setOnClickListener{
            clickarBoton(1)

        }
        Binding!!.fragmentABoton2.setOnClickListener{
            clickarBoton(2)

        }
        Binding!!.fragmentABoton3.setOnClickListener{
            clickarBoton(3)

        }
        Binding!!.fragmentABoton4.setOnClickListener{
            clickarBoton(4)

        }
        Binding!!.fragmentABoton5.setOnClickListener{
            clickarBoton(5)

        }


        return view

    }
    fun clickarBoton(boton:Int){  // creamos esta función para realziar la acción que harán los botones, le pasamos entero con botón pulsado


        //tenemos que saber si el móvil está en modo portrait o landscape, para ello debemos acceder al layout de la activity A y comprobar si existe el framelayout
        // del modo landscape , si existe  tendriamos
        val main = activity as AActivity  // casteamos para obtener la activity A
        val mainBinding = ActivityABinding.bind(main.Binding.root) // vinculamos el main al layout activity_a para poder comprobar si existe el framelayout, no hace falta inflarlo

        if (mainBinding.activityAFrameLayout!= null){ // si existe el frameLayout reemplazamos el fragmento
            val fragment = BFragment.newInstance(boton) // construimos el fragment b con el argumento neceario del newInstance
            val manager = fragmentManager // necesitamos el fragmentmanager para realizar la transacción
            val transaction =manager!!.beginTransaction()
            transaction.replace(mainBinding.activityAFrameLayout.id,fragment) // reemplazamos el framelyout por el fragmento B
            transaction.commit() // confirmamos los cambios de la transacción


        }else{ // caundo el frameLyout no existe= está en portrait , realiza estaas acciones:
            val intent  = Intent(this.context,BActivity::class.java)
            intent.putExtra("BOTON_PULSADO",boton)
            startActivity(intent)

        }


    }
    override fun onDestroyView(){
        super.onDestroyView()
        Binding=null // al destruir la aplicacion limpiamos el binding

    }

    // usamos el new instance para pasar el boton pulsado del fragmento A al fragmento B
}