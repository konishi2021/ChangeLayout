package com.example.samplechangelayoutposition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet
import com.example.samplechangelayoutposition.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var marginY = 16
        binding.txvTapMe.setOnClickListener {
            val layout = binding.cstLayout
            val set = ConstraintSet()

            // Clone layout.
            set.clone(layout)

            if (marginY > 600) marginY = 16
            marginY += 32

            // Edit constraints.
            set.clear(binding.txvTapMe.id, ConstraintSet.TOP)
            set.connect(binding.txvTapMe.id, ConstraintSet.TOP, binding.cstLayout.id, ConstraintSet.TOP, marginY)

            // Apply layout.
            set.applyTo(layout)
        }
    }
}