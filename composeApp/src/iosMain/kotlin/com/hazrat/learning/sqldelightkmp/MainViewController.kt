package com.hazrat.learning.sqldelightkmp

import androidx.compose.ui.window.ComposeUIViewController
import com.hazrat.learning.sqldelightkmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}