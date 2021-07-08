package com.example.recyclerviewcontact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcontact.databinding.ItemContactBinding

class ContactAdapter(
    private val contacts:List<ContactItem>,
    val clickfx:(ContactItem) -> Unit,
    ) :RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(private val binding:ItemContactBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(currentContact:ContactItem) {

            binding.tvTitle.text=currentContact.tv1
            binding.tv2ndtitle.text=currentContact.tv2
            binding.ivone.setImageResource(currentContact.imageResource)
            binding.root.setOnClickListener{4
                clickfx(currentContact)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding:ItemContactBinding= ItemContactBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact= contacts[position]
        holder.bind(currentContact)

    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}
