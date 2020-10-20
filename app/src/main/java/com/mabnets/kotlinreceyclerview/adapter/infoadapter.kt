package com.mabnets.kotlinreceyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mabnets.kotlinreceyclerview.databinding.MyitemBinding
import com.mabnets.kotlinreceyclerview.models.Myinfo

class infoadapter(private  val infos:List<Myinfo>): RecyclerView.Adapter<infoadapter.infoholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): infoholder {
        val binding = MyitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return infoholder(binding)
    }

    override fun getItemCount(): Int =infos.size

    override fun onBindViewHolder(holder: infoholder, position: Int) {
       with(holder){
           with(infos[position]) {
               binding.fnm.text =photo
           }
       }
    }
    inner class infoholder(val binding:MyitemBinding ):RecyclerView.ViewHolder(binding.root){
        /*private val binding = MyitemBinding.bind(view)*/
    }

}