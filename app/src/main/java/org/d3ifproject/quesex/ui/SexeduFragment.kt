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
            val gambar = R.drawable.pubertas
            val judul = R.string.judul_pubertas// WAJIB DI MASUKIN STRING!
            val isi = R.string.isi_pubertas // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }

        binding.cardIdGender.setOnClickListener {
            val gambar = R.drawable.identitas_gender
            val judul = R.string.judul_gender // WAJIB DI MASUKIN STRING!
            val isi = R.string.isi_gender // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }
        binding.cardOrientasiSex.setOnClickListener {
            val gambar = R.drawable.orientasi_sex
            val judul = R.string.judul_orientasi_sex // WAJIB DI MASUKIN STRING!
            val isi = R.string.isi_orientasi_sex // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }
        binding.cardPms.setOnClickListener {
            val gambar = R.drawable.pms
            val judul = R.string.judul_pms // WAJIB DI MASUKIN STRING!
            val isi = R.string.isi_pms // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }
        binding.cardKehamilan.setOnClickListener {
            val gambar = R.drawable.kehamilan
            val judul = R.string.judul_kehamilan // WAJIB DI MASUKIN STRING!
            val isi = R.string.isi_kehamilan // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }
        binding.cardTubuh.setOnClickListener {
            val gambar = R.drawable.tubuh_kita
            val judul = R.string.judul_tubuh // WAJIB DI MASUKIN STRING!
            val isi = R.string.isi_tubuh // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }
        binding.cardReproduksi.setOnClickListener {
            val gambar = R.drawable.reproduksi
            val judul = R.string.judul_reproduksi // WAJIB DI MASUKIN STRING!
            val isi = R.string.isi_reproduksi // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }
        binding.cardHubungan.setOnClickListener {
            val gambar = R.drawable.hubungan
            val judul = R.string.judul_hubungan // WAJIB DI MASUKIN STRING!
            val isi = R.string.isi_hubugan // WAJIB DI MASUKIN STRING!

            val passData = SexeduFragmentDirections.actionSexeduFragmentToSexeduDetailFragment(gambar,judul,isi)
            findNavController().navigate(passData)
        }
    }
}