package com.example.androidcoursepractice

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.androidcoursepractice.di.dbModule
import com.example.androidcoursepractice.di.networkModule
import com.example.androidcoursepractice.di.rootModule
import com.example.androidcoursepractice.presentation.screens.BottomBarScreen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()

//        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)
//        ModoDevOptions.onIllegalScreenModelStoreAccess = ModoDevOptions.ValidationFailedStrategy { throwable ->
//            throw throwable
//        }
//        ModoDevOptions.onIllegalClearState = ModoDevOptions.ValidationFailedStrategy { throwable ->
//            logcat(priority = LogPriority.ERROR) { "Cleaning state of composable, which still can be visible for user." }
//        }

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(rootModule, networkModule, dbModule)
        }
    }

    @Composable
    fun NavHost(){
        val navController = rememberNavController()
        BottomBarScreen(
            navController = navController
        )
    }
}