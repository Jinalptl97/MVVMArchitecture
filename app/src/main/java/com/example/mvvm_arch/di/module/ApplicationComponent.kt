package com.example.mvvm_arch.di.module

import android.app.Application
import android.content.Context
import com.example.mvvm_arch.data.api.NetworkService
import com.example.mvvm_arch.data.repository.TopHeadlineRepository
import com.example.mvvm_arch.di.ApplicationContext
import com.example.mvvm_arch.di.module.ApplicationModule
import com.example.mvvm_arch.utils.MVVMApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: MVVMApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService():NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository
}