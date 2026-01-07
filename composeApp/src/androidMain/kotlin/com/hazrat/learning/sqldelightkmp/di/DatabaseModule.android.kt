package com.hazrat.learning.sqldelightkmp.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import com.hazrat.learning.sqldelightkmp.database.SqlDriverFactory
import com.hazrat.sqldelight.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getDatabaseModule(): Module = module {

    single { SqlDriverFactory(context = get<Context>()).getSqlDriver() }
    single { AppDatabase.invoke(get<SqlDriver>()) }

}