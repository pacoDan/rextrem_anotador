package com.rextrem.anotador.presentation.note_create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rextrem.anotador.data.repository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteCreateViewModel(
    private val repository: NoteRepository
) : ViewModel() {

    private val _text = MutableStateFlow("")
    val text: StateFlow<String> = _text

    fun onTextChange(value: String) {
        _text.value = value
    }

    fun save(onSaved: () -> Unit) {
        viewModelScope.launch {
            repository.addNote(_text.value)
            _text.value = ""
            onSaved()
        }
    }
}