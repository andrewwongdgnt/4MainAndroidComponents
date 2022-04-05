package com.fourmainandroidcomponents.activityapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fourmainandroidcomponents.activityapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).run {
            btn.setOnClickListener {
                myTxt.text = (0..100).random().toString()
            }
            setContentView(root)
        }


    }
}