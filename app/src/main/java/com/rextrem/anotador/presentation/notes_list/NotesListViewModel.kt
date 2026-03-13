package com.rextrem.anotador.presentation.notes_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rextrem.anotador.data.model.Note
import com.rextrem.anotador.data.repository.NoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class NotesListViewModel(
    repository: NoteRepository
) : ViewModel() {

    val notes: StateFlow<List<Note>> =
        repository.observeNotes()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}