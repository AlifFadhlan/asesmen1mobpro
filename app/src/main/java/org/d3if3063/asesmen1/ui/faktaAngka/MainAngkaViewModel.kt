package org.d3if3063.asesmen1.ui.faktaAngka

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3063.asesmen1.model.FunFact
import org.d3if3063.asesmen1.network.ApiStatus
import org.d3if3063.asesmen1.network.FactApi

class MainAngkaViewModel : ViewModel() {
    private val data = MutableLiveData<List<FunFact>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(FactApi.service.getFact())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<FunFact>> = data
    fun getStatus(): LiveData<ApiStatus> = status
}