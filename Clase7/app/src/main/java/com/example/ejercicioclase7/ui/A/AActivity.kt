package com.example.ejercicioclase7.ui.A

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicioclase7.databinding.ActivityABinding

class AActivity : AppCompatActivity() {

    lateinit var Binding: ActivityABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityABinding.inflate(layoutInflater)
        val view = Binding.root
        setContentView(view)
    }
}