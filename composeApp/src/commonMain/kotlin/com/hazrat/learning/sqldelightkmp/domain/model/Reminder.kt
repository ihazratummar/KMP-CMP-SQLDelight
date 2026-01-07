package com.hazrat.learning.sqldelightkmp.domain.model

data class Reminder(
    val id: Int,
    val contactName: String,
    val contactNumber: String,
    val message: String
)
