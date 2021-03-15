package com.example.ejercicioclase7.ui.B

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class BActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        // Enables Always-on
        setAmbientEnabled()
    }
}