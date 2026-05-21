package com.ellepqe.alarmapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ellepqe.alarmapp.databinding.FragmentSettingsBinding
import com.ellepqe.alarmapp.ui.adapters.LanguageAdapter
import com.ellepqe.alarmapp.ui.viewmodel.SettingsViewModel

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SettingsViewModel
    private lateinit var adapter: LanguageAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        setupRecyclerView()
        setupObservers()
        setupListeners()
    }

    private fun setupRecyclerView() {
        adapter = LanguageAdapter()
        binding.languageRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@SettingsFragment.adapter
        }
    }

    private fun setupObservers() {
        viewModel.languages.observe(viewLifecycleOwner) { languages ->
            adapter.submitList(languages)
        }
    }

    private fun setupListeners() {
        binding.exportJsonButton.setOnClickListener {
            viewModel.exportAsJson()
        }
        binding.exportTextButton.setOnClickListener {
            viewModel.exportAsText()
        }
        binding.restoreDefaultsButton.setOnClickListener {
            viewModel.restoreDefaults()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
