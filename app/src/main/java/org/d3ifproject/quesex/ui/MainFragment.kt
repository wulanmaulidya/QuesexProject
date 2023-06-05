package org.d3ifproject.quesex.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.firebase.auth.FirebaseUser
import org.d3ifproject.quesex.R
import org.d3ifproject.quesex.databinding.FragmentMainBinding
import org.d3ifproject.quesex.model.ProfileViewModel

class MainFragment : Fragment() {
    private val contract = FirebaseAuthUIActivityResultContract()
    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        (activity as AppCompatActivity?)?.supportActionBar!!.hide()
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        viewModel.authState.observe(viewLifecycleOwner) { updateUI(it) }

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
