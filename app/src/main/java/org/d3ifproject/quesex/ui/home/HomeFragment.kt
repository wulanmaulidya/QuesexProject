package org.d3ifproject.quesex.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class HomeFragment : Fragment() {

    private val contract = FirebaseAuthUIActivityResultContract()
    private lateinit var viewModel: ProfileViewModel

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)?.supportActionBar!!.hide()
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        viewModel.authState.observe(viewLifecycleOwner) { updateUI(it) }

        binding.btnPerkembangan.setOnClickListener{
            val pertumbuhan = Intent(context, PertumbuhanActivity::class.java)
            startActivity(pertumbuhan)
        }

        binding.btnJenis.setOnClickListener {
            val jenis = Intent(context, JenisActivity::class.java)
            startActivity(jenis)
        }

        binding.btnArtikel.setOnClickListener {
            val artikel = Intent(context, ArtikelActivity::class.java)
            startActivity(artikel)
        }

        binding.fab.setOnClickListener {
            val fab = Intent(context, DataKucingActivity::class.java)
            startActivity(fab)
        }

        binding.vetCare.setOnClickListener {
            val vetcare = Intent(context, VetActivity::class.java)
            startActivity(vetcare)
        }
    }

    private fun updateUI(user: FirebaseUser?) = with(binding) {
        if (user == null) {
            HelloUser.text = "Selamat Datang!"
        } else {
            HelloUser.text = "Hello, " + user.displayName
        }
    }
}