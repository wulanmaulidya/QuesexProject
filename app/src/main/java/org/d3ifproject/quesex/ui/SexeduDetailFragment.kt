package org.d3ifproject.quesex.ui

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        (activity as AppCompatActivity).supportActionBar?.title = getString(args.judul)

        // passing data dari SexeduFragment
        binding.img.setImageResource(args.gambar)
        binding.judul.text = getString(args.judul)
        binding.isi.text = getString(args.isi)
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Arahkan pengguna ke halaman sebelumnya
                requireActivity().onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
