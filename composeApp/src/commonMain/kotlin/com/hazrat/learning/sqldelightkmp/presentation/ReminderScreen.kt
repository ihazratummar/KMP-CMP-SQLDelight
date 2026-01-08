package com.hazrat.learning.sqldelightkmp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import kotlin.random.Random
import kotlin.time.Clock


/**
 * @author hazratummar
 * Created on 06/01/26
 */

@Composable
fun ReminderScreen(
    modifier: Modifier = Modifier,
    reminderViewModel: ReminderViewModel,
    onReminderClick: (String) -> Unit
) {
    var contactName by remember { mutableStateOf("") }
    var contactNumber: String by remember { mutableStateOf("") }
    var message: String by remember { mutableStateOf("") }

    val reminders by reminderViewModel.reminders.collectAsState()

    Surface(
        modifier = modifier.fillMaxSize().statusBarsPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = contactName,
                onValueChange = {
                    contactName = it
                },
                label = { Text("Contact Name") }
            )
            Spacer(Modifier.height(8.dp))
            TextField(
                value = contactNumber,
                onValueChange = {
                    contactNumber = it
                },
                label = { Text("Contact Number") }
            )
            Spacer(Modifier.height(8.dp))
            TextField(
                value = message,
                onValueChange = {
                    message = it
                },
                label = { Text("Message") },
                maxLines = 3,
                modifier = Modifier.height(100.dp)
            )
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {
                        reminderViewModel.saveReminder(
                            contactName = contactName,
                            contactNumber = contactNumber,
                            message = message
                        )
                        contactName = ""
                        contactNumber = ""
                        message = ""
                    }
                ) {
                    Text("Save")
                }
            }
            LazyColumn(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                items(reminders) {reminder->

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                onReminderClick(reminder.message)
                            }
                            .background(
                                color = MaterialTheme.colorScheme.surfaceContainer,
                                shape = RoundedCornerShape(12.dp)
                            )
                        ,
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp)
                                .clickable {
                                    reminder.id.let {
                                        reminderViewModel.delete(id = it)
                                    }
                                }
                        )

                        Column(
                            modifier = Modifier.fillMaxWidth().padding(8.dp)
                        ) {
                            Text(reminder.contactName)
                            Text(reminder.contactNumber)
                            Text(reminder.message)
                        }
                    }
                }
            }
        }
    }
}