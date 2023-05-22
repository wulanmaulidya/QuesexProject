package org.d3ifproject.quesex.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3ifproject.quesex.databinding.ActivitySexeduBinding
import org.d3ifproject.quesex.databinding.FragmentMainBinding

class SexeduFragment : Fragment() {
    private lateinit var binding: ActivitySexeduBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivitySexeduBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}