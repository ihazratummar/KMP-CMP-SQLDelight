package com.hazrat.learning.sqldelightkmp.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.hazrat.learning.sqldelightkmp.domain.model.Reminder
import com.hazrat.learning.sqldelightkmp.domain.repository.ReminderRepository
import com.hazrat.sqldelight.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


/**
 * @author hazratummar
 * Created on 06/01/26
 */

class ReminderRepositoryImpl(
    private val appDatabase: AppDatabase
) : ReminderRepository {

    override fun getAllReminder(): Flow<List<Reminder>> {
        return appDatabase.appDatabaseQueries
            .getAllRemider()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { reminders ->
                reminders.map {
                    Reminder(
                        id = it.id.toInt(),
                        contactName = it.contact_name,
                        contactNumber = it.contact_number,
                        message = it.message
                    )
                }
            }
    }

    override suspend fun upsert(
        id: Int,
        contactName: String,
        contactNumber: String,
        message: String
    ) {
        appDatabase.appDatabaseQueries
            .upsert(
                id = id.toLong(),
                contact_name = contactName,
                contact_number = contactNumber,
                message = message
            )
    }

    override suspend fun delete(id: Int) {
        appDatabase.appDatabaseQueries
            .delete(id = id.toLong())
    }
}