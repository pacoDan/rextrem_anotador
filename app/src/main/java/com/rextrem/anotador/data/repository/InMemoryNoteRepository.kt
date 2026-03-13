package com.rextrem.anotador.data.repository

import com.rextrem.anotador.data.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InMemoryNoteRepository : NoteRepository {

    private val notes = MutableStateFlow<List<Note>>(emptyList())
    private var nextId = 1L

    override fun observeNotes(): Flow<List<Note>> = notes.asStateFlow()

    override suspend fun addNote(text: String) {
        val trimmed = text.trim()
        if (trimmed.isEmpty()) return

        val newNote = Note(id = nextId++, text = trimmed)
        notes.value = listOf(newNote) + notes.value
    }
}