package com.ellepqe.alarmapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ellepqe.alarmapp.data.model.MoonTime
import com.ellepqe.alarmapp.data.model.SunTime
import kotlinx.coroutines.launch

class SunMoonViewModel : ViewModel() {
    private val _sunMoonTimes = MutableLiveData<List<Any>>()
    val sunMoonTimes: LiveData<List<Any>> = _sunMoonTimes

    private val _sunrises = MutableLiveData<List<SunTime>>()
    val sunrises: LiveData<List<SunTime>> = _sunrises

    private val _sunsets = MutableLiveData<List<SunTime>>()
    val sunsets: LiveData<List<SunTime>> = _sunsets

    private val _moonTimes = MutableLiveData<List<MoonTime>>()
    val moonTimes: LiveData<List<MoonTime>> = _moonTimes

    fun loadSunMoonTimes() {
        viewModelScope.launch {
            // Load times
        }
    }

    fun addSunrise(time: String) {
        viewModelScope.launch {
            // Add sunrise
        }
    }

    fun addSunset(time: String) {
        viewModelScope.launch {
            // Add sunset
        }
    }

    fun addMoonTime(phase: String, time: String) {
        viewModelScope.launch {
            // Add moon time
        }
    }

    fun updateTime(id: Int, newTime: String) {
        viewModelScope.launch {
            // Update time
        }
    }

    fun deleteTime(id: Int) {
        viewModelScope.launch {
            // Delete time
        }
    }
}
