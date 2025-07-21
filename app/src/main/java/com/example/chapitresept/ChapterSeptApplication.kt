package com.example.chapitresept

import android.app.Application
import com.example.chapitresept.di.appModules
import org.koin.core.context.startKoin

class ChapterSeptApplication : Application () {

    override fun onCreate () {

        super.onCreate ()
        startKoin {
            modules (appModules)
        }
    }

}