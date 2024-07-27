package com.bankmisr.notesapp2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bankmisr.notesapp2.database.Note
import com.bankmisr.notesapp2.database.RoomDBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(app:Application): AndroidViewModel(app) {

    private val db= RoomDBHelper.getInstance(app)
    fun upsert(n: Note){
        viewModelScope.launch(Dispatchers.IO){ db.dao.upsertNote(n)}
    }
    fun delete(n:Note){
        viewModelScope.launch(Dispatchers.IO) { db.dao.deleteNote(n) }
    }
    fun getNotes()=db.dao.getAllNotes()
}