package com.hazrat.learning.sqldelightkmp.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin


/**
 * @author hazratummar
 * Created on 06/01/26
 */
 
fun initKoin(koinApplication: ((KoinApplication) -> Unit)? = null) {
    startKoin {
        koinApplication?.invoke(this)
        modules(
            getDatabaseModule(),
            getSharedModule()
        )
    }
}