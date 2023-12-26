package com.example.mvvm_arch.utils

import android.app.Application
import com.example.mvvm_arch.di.module.ApplicationComponent
import com.example.mvvm_arch.di.module.ApplicationModule

class MVVMApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies(){
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}