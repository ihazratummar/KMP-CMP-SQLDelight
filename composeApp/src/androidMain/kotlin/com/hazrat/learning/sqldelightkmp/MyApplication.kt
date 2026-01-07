package com.hazrat.learning.sqldelightkmp

import android.app.Application
import android.content.Context
import com.hazrat.learning.sqldelightkmp.di.initKoin
import org.koin.dsl.module


/**
 * @author hazratummar
 * Created on 06/01/26
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            it.modules(
                module { single<Context> { this@MyApplication.applicationContext } }
            )
        }
    }
}