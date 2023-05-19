package org.d3if3063.asesmen1.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3063.asesmen1.db.RanPickDao

class HistoriViewModel(private val db: RanPickDao) : ViewModel() {
    val data = db.getLastPick()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }

}
