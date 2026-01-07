package com.hazrat.learning.sqldelightkmp.database

import app.cash.sqldelight.db.SqlDriver


/**
 * @author hazratummar
 * Created on 06/01/26
 */

expect class SqlDriverFactory(
    context: Any? = null
) {
    fun getSqlDriver() : SqlDriver
}