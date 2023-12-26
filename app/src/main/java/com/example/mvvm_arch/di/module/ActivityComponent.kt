package com.example.mvvm_arch.di.module

import com.example.mvvm_arch.di.ActivityScope
import com.example.mvvm_arch.ui.topheadlines.TopHeadlineActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject (activity:TopHeadlineActivity)
}