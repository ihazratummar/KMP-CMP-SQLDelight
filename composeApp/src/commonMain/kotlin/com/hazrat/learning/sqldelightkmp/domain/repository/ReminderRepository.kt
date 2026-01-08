package com.hazrat.learning.sqldelightkmp.domain.repository

import com.hazrat.learning.sqldelightkmp.domain.model.Reminder
import kotlinx.coroutines.flow.Flow


/**
 * @author hazratummar
 * Created on 06/01/26
 */

interface ReminderRepository {


    fun getAllReminder () : Flow<List<Reminder>>
    suspend fun insertReminder(contactName: String, contactNumber: String, message: String)
    suspend fun delete(id: String)

}