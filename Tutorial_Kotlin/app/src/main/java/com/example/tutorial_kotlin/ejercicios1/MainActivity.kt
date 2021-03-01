package com.example.tutorial_kotlin.ejercicios1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tutorial_kotlin.R

// es la pantalla visual de una app - ficehro kotlin/java y otro XML(diseño)
// muy importante la pila de actividades, si no necesitamos la acitividad anterior hay que terminarla

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}