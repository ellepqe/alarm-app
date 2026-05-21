package com.ellepqe.alarmapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ellepqe.alarmapp.data.model.Note
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel() {
    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    private val _selectedNote = MutableLiveData<Note>()
    val selectedNote: LiveData<Note> = _selectedNote

    fun loadNotes() {
        viewModelScope.launch {
            // Load notes
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            // Add note
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            // Update note
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            // Delete note
        }
    }

    fun selectNote(note: Note) {
        _selectedNote.value = note
    }
}
