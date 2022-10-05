package com.dacha.hellokotlin6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dacha.hellokotlin6.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private  val data = arrayListOf<Character>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loaddata()
        val adapter = CharacterAdapter(data , this::onClick)
        binding.recyclerview.adapter = adapter
    }

    private fun loaddata() {
        data.add(Character("Rick" ,"Alive" ,"https://www.pngkey.com/png/detail/3-35089_rick-sprite-rick-sanchez.png"))
        data.add(Character("Morty" ,"Alive" ,"https://www.pngkey.com/png/detail/3-35089_rick-sprite-rick-sanchez.png"))
        data.add(Character("Albert" ,"Alive" ,"https://www.pngkey.com/png/detail/3-35089_rick-sprite-rick-sanchez.png"))
        data.add(Character("Jerry" ,"Alive" ,"https://www.pngkey.com/png/detail/3-35089_rick-sprite-rick-sanchez.png"))

    }
    private fun onClick(position:Int){
        val bundle= Bundle()
        bundle.putSerializable("key" , data[position])
        findNavController().navigate(R.id.secondFragment , bundle)

    }

}