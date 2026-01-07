package com.hazrat.learning.sqldelightkmp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hazrat.learning.sqldelightkmp.domain.repository.ReminderRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


/**
 * @author hazratummar
 * Created on 06/01/26
 */

class ReminderViewModel(
    private val repository: ReminderRepository
) : ViewModel() {

    val reminders = repository.getAllReminder()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun saveReminder(id: Int, contactName: String, contactNumber: String, message: String){
        viewModelScope.launch {
            repository.upsert(id, contactName, contactNumber, message)
        }
    }

    fun delete(id: Int){
        viewModelScope.launch {
            repository.delete(id)
        }
    }

}