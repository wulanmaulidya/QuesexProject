package org.d3ifproject.quesex.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.google.firebase.auth.FirebaseUser
import org.d3ifproject.quesex.R
import org.d3ifproject.quesex.databinding.FragmentProfileBinding
import org.d3ifproject.quesex.model.ProfileViewModel

class ProfileFragment : Fragment() {

    private val contract = FirebaseAuthUIActivityResultContract()
    private val signInLauncher = registerForActivityResult(contract) {}
    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        binding.login.setOnClickListener {
            mulaiLogin() }
            viewModel.authState.observe(viewLifecycleOwner) {
                updateUI(it) }
            }



            private fun updateUI(user: FirebaseUser?) = with(binding) {
                if (user == null) {
                    namaTextView.visibility = View.GONE
                    imageView.visibility = View.GONE
                    login.visibility = View.GONE
                } else {
                    namaTextView.text =
                        user.displayName
                    Glide.with(this@ProfileFragment).load(user.photoUrl).into(imageView)
                    namaTextView.visibility = View.VISIBLE
                    imageView.visibility = View.VISIBLE
                    login.text = getString(R.string.logout)
                }
            }

            private fun mulaiLogin() {
                if (binding.login.text == getString(R.string.logout)) {
                    AuthUI.getInstance().signOut(requireActivity())
                    val intent = Intent(context, LoginActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                    return
                }

                val providers = arrayListOf(AuthUI.IdpConfig.GoogleBuilder().build())
                val intent = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build()
                signInLauncher.launch(intent)
            }
        }