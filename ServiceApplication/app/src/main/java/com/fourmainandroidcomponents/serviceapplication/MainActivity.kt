package com.fourmainandroidcomponents.serviceapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fourmainandroidcomponents.serviceapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).run {

            localServiceBtn.setOnClickListener {
                Intent(this@MainActivity, MyService::class.java).also { intent ->
                    startService(intent)
                }
            }
            otherServiceBtn.setOnClickListener {
                val i = Intent().apply {
                    setClassName("com.fourmainandroidcomponents.serviceotherapplication", "com.fourmainandroidcomponents.serviceotherapplication.MyService")
                }
                startForegroundService(i)
            }

            setContentView(root)
        }
    }
}