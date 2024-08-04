package com.example.firstclass

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firstclass.databinding.ActivityItemViewBinding
import com.example.firstclass.databinding.ActivityMainBinding
import com.example.firstclass.databinding.AlertdialogViewBinding
import com.example.firstclass.databinding.TitleBarBinding
import com.example.firstclass.databinding.ViewholderListItemBinding

class ItemViewActivity : AppCompatActivity() {
    companion object {
        val ITEM_NAME = "item_name"
    }
    private lateinit var binding: ActivityItemViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityItemViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val text = intent.getStringExtra(ITEM_NAME)
        binding.content.text = text
    }
}