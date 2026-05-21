package com.ellepqe.alarmapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ellepqe.alarmapp.data.model.Alarm
import com.ellepqe.alarmapp.data.repository.AlarmRepository
import kotlinx.coroutines.launch

class AlarmViewModel : ViewModel() {
    private val _alarms = MutableLiveData<List<Alarm>>()
    val alarms: LiveData<List<Alarm>> = _alarms

    private val _selectedAlarm = MutableLiveData<Alarm>()
    val selectedAlarm: LiveData<Alarm> = _selectedAlarm

    fun loadAlarms() {
        viewModelScope.launch {
            // Load alarms from repository
        }
    }

    fun addAlarm(alarm: Alarm) {
        viewModelScope.launch {
            // Insert alarm
        }
    }

    fun updateAlarm(alarm: Alarm) {
        viewModelScope.launch {
            // Update alarm
        }
    }

    fun deleteAlarm(alarm: Alarm) {
        viewModelScope.launch {
            // Delete alarm
        }
    }

    fun selectAlarm(alarm: Alarm) {
        _selectedAlarm.value = alarm
    }
}
