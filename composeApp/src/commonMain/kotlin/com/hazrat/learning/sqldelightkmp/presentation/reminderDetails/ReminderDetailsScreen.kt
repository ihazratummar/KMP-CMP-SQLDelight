package com.hazrat.learning.sqldelightkmp.presentation.reminderDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * @author hazratummar
 * Created on 07/01/26
 */

@Composable
fun ReminderDetailsScreen(
    reminder: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize().padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(reminder, color = Color.Red)
    }
}