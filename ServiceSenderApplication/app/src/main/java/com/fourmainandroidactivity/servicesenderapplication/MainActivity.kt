package com.fourmainandroidactivity.servicesenderapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fourmainandroidactivity.servicesenderapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityMainBinding.inflate(layoutInflater).run {
            btn.setOnClickListener {
                val i = Intent().apply {
                    setClassName("com.fourmainandroidactivity.serviceotherapplication", "com.fourmainandroidactivity.serviceapplication.MyService")
                }
                startForegroundService(i)
            }
            setContentView(root)
        }
    }
}