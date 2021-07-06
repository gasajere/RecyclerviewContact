package com.example.recyclerviewcontact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.recyclerviewcontact.databinding.ActivityContact2Binding

class Contact : AppCompatActivity() {
    private lateinit var binding: ActivityContact2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContact2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}