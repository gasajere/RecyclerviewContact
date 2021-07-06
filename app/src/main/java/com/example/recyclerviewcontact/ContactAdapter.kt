package com.example.recyclerviewcontact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcontact.databinding.ItemContactBinding

class ContactAdapter(private val contacts:List<ContactItem>,
                     private val listener:OnItemClickListener) :RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(private val binding:ItemContactBinding):RecyclerView.ViewHolder(binding.root),
        View.OnClickListener{
        fun bind(currentContact:ContactItem) {

            binding.tvTitle.text=currentContact.tv1
            binding.tv2ndtitle.text=currentContact.tv2
            binding.ivone.setImageResource(currentContact.imageResource)

            itemView.setOnClickListener(this)


        }

        override fun onClick(v: View?) {
            val position=adapterPosition
            val item=
                listener.onContactClick(position)
        }

    }  interface OnItemClickListener{

        fun onContactClick (position: Int)
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