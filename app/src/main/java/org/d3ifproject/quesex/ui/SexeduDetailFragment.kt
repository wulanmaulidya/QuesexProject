package org.d3ifproject.quesex.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import org.d3ifproject.quesex.databinding.ActivityDetailSexeduBinding

class SexeduDetailFragment : Fragment() {
    private lateinit var binding: ActivityDetailSexeduBinding
    val args: SexeduDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ActivityDetailSexeduBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Memberikan judul pada title bar halaman
        (activity as AppCompatActivity).supportActionBar?.title = args.judul.toString()

        // passing data dari SexeduFragment
        binding.img.setImageResource(args.gambar)
        binding.judul.text = args.judul.toString()
        binding.isi.text = args.isi.toString()
    }
}