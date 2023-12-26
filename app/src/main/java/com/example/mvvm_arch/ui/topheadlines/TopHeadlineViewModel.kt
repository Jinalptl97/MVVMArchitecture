package com.example.mvvm_arch.ui.topheadlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_arch.data.model.Article
import com.example.mvvm_arch.data.repository.TopHeadlineRepository
import com.example.mvvm_arch.ui.base.UiState
import com.example.mvvm_arch.utils.AppConstant.COUNTRY
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Thread.State

class TopHeadlineViewModel(private val topHeadlineRepository: TopHeadlineRepository):ViewModel() {
    private val _uistate= MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val uiState:StateFlow<UiState<List<Article>>> = _uistate

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines(){
        viewModelScope.launch {
            topHeadlineRepository.getTopHeadlines(COUNTRY)
                .catch { e->
                    _uistate.value=UiState.Error(e.toString())
                }
                .collect{
                    _uistate.value=UiState.Success(it)
                }
        }
    }
}