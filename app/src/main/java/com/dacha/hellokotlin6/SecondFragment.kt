package com.dacha.hellokotlin6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dacha.hellokotlin6.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireContext()) , container , false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val profile: Character = arguments?.getSerializable("key") as Character
        binding.name.text = profile.name.toString()
        binding.life.text = profile.life.toString()
        Glide.with(binding.image).load(profile.image).into(binding.image)

    }

}