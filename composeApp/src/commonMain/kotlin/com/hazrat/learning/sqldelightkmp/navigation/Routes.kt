package com.hazrat.learning.sqldelightkmp.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/**
 * @author hazratummar
 * Created on 07/01/26
 */

@Serializable
sealed interface Routes : NavKey {

    @Serializable
    data object Home : Routes, NavKey

    @Serializable
    data object ReminderList : Routes, NavKey


    @Serializable
    data class ReminderDetails(val reminderDescription: String) : Routes, NavKey

}