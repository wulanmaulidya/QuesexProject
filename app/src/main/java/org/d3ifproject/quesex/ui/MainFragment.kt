package org.d3ifproject.quesex.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseUser
import org.d3ifproject.quesex.R
import org.d3ifproject.quesex.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cardSexEdu.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_sexeduFragment)
        }

        binding.cardGame.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
        }
    }
    private fun updateUI(user: FirebaseUser?) = with(binding) {
        if (user == null) {
            HelloUser.text = "Selamat Datang!"
        } else {
            HelloUser.text = "Halo, " + user.displayName
        }
    }
}
