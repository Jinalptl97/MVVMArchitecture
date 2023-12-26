package com.example.mvvm_arch.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.mvvm_arch.data.repository.TopHeadlineRepository
import com.example.mvvm_arch.di.ActivityContext
import dagger.Module
import dagger.Provides
import com.example.mvvm_arch.ui.topheadlines.TopHeadlineViewModel
import com.example.mvvm_arch.ui.topheadlines.TopHeadlineAdapter
import com.example.mvvm_arch.ui.base.ViewModelProviderFactory

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun providecontext(): Context {
        return activity
    }

    @Provides
    fun provideTopheadlinesViewModel(topHeadlineRepository: TopHeadlineRepository):TopHeadlineViewModel{
        return ViewModelProvider(activity,
        ViewModelProviderFactory(TopHeadlineViewModel::class){
            TopHeadlineViewModel(topHeadlineRepository)
        })[TopHeadlineViewModel::class.java]
    }
    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())
}