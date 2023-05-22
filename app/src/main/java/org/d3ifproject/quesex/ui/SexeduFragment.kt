package org.d3ifproject.quesex.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.d3ifproject.quesex.R
import org.d3ifproject.quesex.databinding.FragmentListSexeduBinding

class SexeduFragment : Fragment() {
    private lateinit var binding: FragmentListSexeduBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListSexeduBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cardPubertas.setOnClickListener {
            val gambar = R.drawable.logo
            val judul = "Judulnya apa" // WAJIB DI MASUKIN STRING!
            val isi = "isinya apa" // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }

        binding.cardIdGender.setOnClickListener {
            val gambar = R.drawable.logo
            val judul = "Judulnya apa" // WAJIB DI MASUKIN STRING!
            val isi = "isinya apa" // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }

        // sisanya lanjutin & bikin id di cardnya kayak tadi.
    }
}