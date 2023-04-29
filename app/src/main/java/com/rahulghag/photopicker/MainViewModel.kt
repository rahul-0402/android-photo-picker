package com.rahulghag.photopicker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainScreenUiState())
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    fun onEvent(event: MainScreenUiEvent) {
        when (event) {
            is MainScreenUiEvent.ImageSelected -> {
                _uiState.update {
                    it.copy(
                        selectedImageUri = event.selectedImageUri,
                    )
                }
            }

            is MainScreenUiEvent.ImageRemoved -> {
                _uiState.update {
                    it.copy(
                        selectedImageUri = null
                    )
                }
            }
        }
    }
}