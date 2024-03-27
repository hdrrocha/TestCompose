package com.example.testcompose.aplication

import android.app.Application
import androidx.compose.runtime.Composable
import com.example.testcompose.injection.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyAppApplication  : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyAppApplication)
            modules(Modules.all)
        }
    }
}