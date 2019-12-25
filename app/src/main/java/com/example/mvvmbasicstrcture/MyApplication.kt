package com.example.mvvmbasicstrcture

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

class MyApplication : Application() {

    companion object Singleton {
        private lateinit var app: MyApplication
        fun getInstance(): MyApplication {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        Retrofit.init()
    }
}