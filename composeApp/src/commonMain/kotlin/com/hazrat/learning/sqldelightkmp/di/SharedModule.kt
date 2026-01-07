package com.hazrat.learning.sqldelightkmp.di

import com.hazrat.learning.sqldelightkmp.data.repository.ReminderRepositoryImpl
import com.hazrat.learning.sqldelightkmp.domain.repository.ReminderRepository
import com.hazrat.learning.sqldelightkmp.presentation.ReminderViewModel
import com.hazrat.sqldelight.AppDatabase
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


/**
 * @author hazratummar
 * Created on 06/01/26
 */

fun getSharedModule() : Module = module {
    single <ReminderRepository>{ ReminderRepositoryImpl(appDatabase = get<AppDatabase>()) }

    viewModel { ReminderViewModel(get()) }
}