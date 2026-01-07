package com.hazrat.learning.sqldelightkmp.data.local

import com.hazrat.learning.sqldelightkmp.domain.model.Reminder

object ReminderEntityMapper {

    fun toDomain(entity: ReminderEntity) : Reminder {
        return Reminder(
            id = entity.id,
            contactName = entity.contactName,
            contactNumber = entity.contactNumber,
            message = entity.message
        )
    }

    fun toEntity(reminder: Reminder) : ReminderEntity {
        return ReminderEntity(
            id = reminder.id,
            contactName = reminder.contactName,
            contactNumber = reminder.contactNumber,
            message = reminder.message
        )
    }

}