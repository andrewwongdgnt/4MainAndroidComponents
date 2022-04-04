package com.fourmainandroidactivity.serviceapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fourmainandroidactivity.serviceapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityMainBinding.inflate(layoutInflater).run {
            btn.setOnClickListener {
                val i = Intent().apply {
                    setClassName("com.fourmainandroidactivity.serviceotherapplication", "com.fourmainandroidactivity.serviceotherapplication.MyService")
                }
                startForegroundService(i)
            }
            btn2.setOnClickListener {
                Intent(this@MainActivity, MyService::class.java).also { intent ->
                    startService(intent)
                }            }
            setContentView(root)
        }
    }
}