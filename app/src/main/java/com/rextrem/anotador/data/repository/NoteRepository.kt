package com.rextrem.anotador.data.repository

import com.rextrem.anotador.data.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun observeNotes(): Flow<List<Note>>
    suspend fun addNote(text: String)
}