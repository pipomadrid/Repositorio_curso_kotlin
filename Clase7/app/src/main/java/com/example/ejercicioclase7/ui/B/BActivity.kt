package com.example.ejercicioclase7.ui.B

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicioclase7.databinding.ActivityABinding


class BActivity : AppCompatActivity() {
    private lateinit var Binding: ActivityABinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityABinding.inflate(layoutInflater)
        val view = Binding.root
        setContentView(view)
    }

}