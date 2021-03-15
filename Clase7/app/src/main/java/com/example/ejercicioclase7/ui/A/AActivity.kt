package com.example.ejercicioclase7.ui.A

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicioclase7.R
import com.example.ejercicioclase7.databinding.ActivityBBinding

class AActivity : AppCompatActivity() {

    private lateinit var Binding:ActivityBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityBBinding.inflate(layoutInflater)
        val view = Binding.root
        setContentView(view)
    }
}