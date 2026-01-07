package com.hazrat.learning.sqldelightkmp.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.hazrat.sqldelight.AppDatabase

actual class SqlDriverFactory actual constructor(context: Any?) {
    actual fun getSqlDriver(): SqlDriver {
        return NativeSqliteDriver(
            AppDatabase.Schema,
            "AppDatabase.db"
        )
    }
}