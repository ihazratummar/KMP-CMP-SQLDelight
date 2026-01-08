package com.hazrat.learning.sqldelightkmp.domain.model

data class Reminder(
    val id: String,
    val contactName: String,
    val contactNumber: String,
    val message: String,
    val scheduledAt: Long,
    val state: String,
    val createdAt: Long,
    val updatedAt: Long
)
