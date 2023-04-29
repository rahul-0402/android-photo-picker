package com.rahulghag.photopicker

import android.net.Uri

sealed class MainScreenUiEvent {
    data class ImageSelected(val selectedImageUri: Uri) : MainScreenUiEvent()
    object ImageRemoved : MainScreenUiEvent()
}