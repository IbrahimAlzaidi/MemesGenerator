package com.example.memesgenerator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.memesgenerator.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.button.setOnClickListener {
            val memeName = binding.memeName.selectedItem.toString()
            val topText = binding.topText.text
            val bottomText = binding.bottomText.text
            makeRequestUsingOkhttp(memeName.toString(), topText.toString(), bottomText.toString())

        }
        }

    private fun makeRequestUsingOkhttp(memeName:String, topText: String, bottomText: String) {
            Glide.with(this@MainActivity).load("https://apimeme.com/meme?meme=$memeName&top=$topText&bottom=$bottomText")
            .into(binding.image)
    }
    }
