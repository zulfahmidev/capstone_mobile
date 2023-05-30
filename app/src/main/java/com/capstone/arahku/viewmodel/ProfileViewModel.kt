package com.capstone.arahku.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.arahku.model.UserPreference
import kotlinx.coroutines.launch

class ProfileViewModel(private val preference: UserPreference): ViewModel() {
    fun logout() = viewModelScope.launch {
        preference.logout()
    }
}