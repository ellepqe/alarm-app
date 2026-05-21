package com.ellepqe.alarmapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ellepqe.alarmapp.databinding.FragmentAlarmsBinding
import com.ellepqe.alarmapp.ui.adapters.AlarmAdapter
import com.ellepqe.alarmapp.ui.viewmodel.AlarmViewModel

class AlarmsFragment : Fragment() {
    private var _binding: FragmentAlarmsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AlarmViewModel
    private lateinit var adapter: AlarmAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlarmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlarmViewModel::class.java)
        setupRecyclerView()
        setupObservers()
        setupListeners()
    }

    private fun setupRecyclerView() {
        adapter = AlarmAdapter()
        binding.alarmsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@AlarmsFragment.adapter
        }
    }

    private fun setupObservers() {
        viewModel.alarms.observe(viewLifecycleOwner) { alarms ->
            adapter.submitList(alarms)
        }
    }

    private fun setupListeners() {
        binding.addAlarmButton.setOnClickListener {
            // Navigate to add alarm
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
