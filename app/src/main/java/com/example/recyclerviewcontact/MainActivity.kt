package com.example.recyclerviewcontact

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerviewcontact.databinding.ActivityContact2Binding
import com.example.recyclerviewcontact.databinding.ActivityMainBinding
import com.example.recyclerviewcontact.databinding.ItemContactBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var myContactAdapter: ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exampleList=makeList(2)
        myContactAdapter= ContactAdapter(
            exampleList,
        ) {
            val intent = Intent(this, Contact::class.java)
            intent.putExtra("tvTitle", it.tv1)
            intent.putExtra("tv2ndtitle", it.tv2)
            intent.putExtra("Ivone", it.imageResource)
            startActivity(intent)
        }

        binding.recyclerView.adapter = myContactAdapter
    }

    private fun makeList(size:Int):List<ContactItem>{
        val lists= ArrayList<ContactItem>()
        for (i in 0 until size){
            val drawable= when (i%3){
                0 -> R.drawable.ic_contact
                1 -> R.drawable.ic_face
                2 -> R.drawable.ic_stranger
                3 -> R.drawable.ic_hey
                4 -> R.drawable.ic_verified
                else -> R.drawable.ic_verified
            }
            val contacts:List<ContactItem> = listOf(
                ContactItem(drawable, "Terence", "Sajere"),
                ContactItem(R.drawable.ic_stranger, "Jadon", "Sancho"),
                ContactItem(R.drawable.ic_hey, "Raheem", "Sterling"),
                ContactItem(R.drawable.ic_verified, "Moses", "Igbedion"),
                ContactItem(drawable, "Maro","Idiowa"),
                ContactItem(R.drawable.ic_verified,"Sasuke","Uchiha"),
                ContactItem(R.drawable.ic_stranger,"Kakashi","Hatake"),
                ContactItem(R.drawable.ic_hey,"Leon","Bailey"),
                ContactItem(R.drawable.ic_verified,"Jason","Vorhees"),
                ContactItem(R.drawable.ic_face,"Natsu","Dragneel"))


            lists += contacts


        }
        return lists
    }

}



