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
import kotlin.random.Random
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid


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
                        id = it.id,
                        contactName = it.contact_name,
                        contactNumber = it.contact_number,
                        message = it.message,
                        scheduledAt = it.scheduled_at,
                        state = it.state,
                        createdAt = it.created_at,
                        updatedAt = it.updated_at
                    )
                }
            }
    }

    @OptIn(ExperimentalTime::class, ExperimentalUuidApi::class)
    override suspend fun insertReminder(
        contactName: String,
        contactNumber: String,
        message: String
    ) {
        appDatabase.appDatabaseQueries
            .insertReminder(
                id = Uuid.random().toString(),
                contact_name = contactName,
                contact_number = contactNumber,
                message = message,
                scheduled_at = Clock.System.now().epochSeconds,
                state = "SCHEDULED",
                created_at = Clock.System.now().epochSeconds,
                updated_at =Clock.System.now().epochSeconds,
            )
    }

    override suspend fun delete(id: String) {
        appDatabase.appDatabaseQueries
            .delete(id = id)
    }
}