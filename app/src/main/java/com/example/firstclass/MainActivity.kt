package com.example.firstclass

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       setContentView(R.layout.activity_main)
        val textView1 = findViewById<TextView>(R.id.tv1)
        val textView2 = findViewById<TextView>(R.id.tv2)
        val textView3 = findViewById<TextView>(R.id.tv3)

        textView1.text = "Rajjesh"
        textView2.text = "Mukesh"
        textView3.text = "Dhiraj"

    }
}