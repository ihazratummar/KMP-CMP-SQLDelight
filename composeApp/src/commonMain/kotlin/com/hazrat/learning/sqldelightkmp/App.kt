package com.hazrat.learning.sqldelightkmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hazrat.learning.sqldelightkmp.navigation.NavigationRoot
import com.hazrat.learning.sqldelightkmp.presentation.ReminderScreen
import com.hazrat.learning.sqldelightkmp.presentation.ReminderViewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

import sqldelightkmp.composeapp.generated.resources.Res
import sqldelightkmp.composeapp.generated.resources.compose_multiplatform

@Composable
fun App() {
    MaterialTheme {
        Scaffold{paddingValues ->
            NavigationRoot(
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}