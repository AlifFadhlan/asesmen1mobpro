package org.d3if3063.asesmen1.ui.faktaAngka

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3063.asesmen1.R
import org.d3if3063.asesmen1.model.FunFact
import org.d3if3063.asesmen1.network.FactApi

class MainAngkaViewModel : ViewModel() {
    private val data = MutableLiveData<List<FunFact>>()

    init {
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            try {
                data.postValue(FactApi.service.getFact())
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
            }
        }
    }

    fun getData(): LiveData<List<FunFact>> = data

}