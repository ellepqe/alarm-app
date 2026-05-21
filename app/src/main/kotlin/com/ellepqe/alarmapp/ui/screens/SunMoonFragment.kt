package com.ellepqe.alarmapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ellepqe.alarmapp.databinding.FragmentSunMoonBinding
import com.ellepqe.alarmapp.ui.adapters.SunMoonAdapter
import com.ellepqe.alarmapp.ui.viewmodel.SunMoonViewModel

class SunMoonFragment : Fragment() {
    private var _binding: FragmentSunMoonBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SunMoonViewModel
    private lateinit var adapter: SunMoonAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSunMoonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SunMoonViewModel::class.java)
        setupRecyclerView()
        setupObservers()
        setupListeners()
    }

    private fun setupRecyclerView() {
        adapter = SunMoonAdapter()
        binding.sunMoonRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@SunMoonFragment.adapter
        }
    }

    private fun setupObservers() {
        viewModel.sunMoonTimes.observe(viewLifecycleOwner) { times ->
            adapter.submitList(times)
        }
    }

    private fun setupListeners() {
        binding.addSunriseButton.setOnClickListener {
            // Add sunrise
        }
        binding.addSunsetButton.setOnClickListener {
            // Add sunset
        }
        binding.addMoonFullButton.setOnClickListener {
            // Add full moon
        }
        binding.addMoonHalfButton.setOnClickListener {
            // Add half moon
        }
        binding.addMoonNewButton.setOnClickListener {
            // Add new moon
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
