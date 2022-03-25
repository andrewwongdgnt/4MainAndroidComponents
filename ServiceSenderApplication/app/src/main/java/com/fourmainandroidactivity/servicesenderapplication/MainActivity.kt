package com.fourmainandroidactivity.servicesenderapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fourmainandroidactivity.servicesenderapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityMainBinding.inflate(layoutInflater).run {
            btn.setOnClickListener {

            }
            setContentView(root)
        }
    }
}