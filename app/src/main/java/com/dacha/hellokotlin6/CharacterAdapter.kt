package com.dacha.hellokotlin6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dacha.hellokotlin6.databinding.FragmentFirstBinding
import com.dacha.hellokotlin6.databinding.ItemListBinding
import org.w3c.dom.CharacterData

class CharacterAdapter(private val data: ArrayList<Character> , private val onClick:(pos: Int) -> Unit):RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return  CharacterViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context) ,parent , false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener{
            onClick(position)
        }
    }

    override fun getItemCount(): Int = data.size


    inner class CharacterViewHolder(private var binding: ItemListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(character: Character){
            binding.name.text = character.name.toString()
            binding.life.text = character.life.toString()
            Glide.with(binding.image).load(character.image).into(binding.image)
        }

    }
}