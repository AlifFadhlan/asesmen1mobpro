package org.d3if3063.asesmen1.ui.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3063.asesmen1.db.RanPickDao

class RandomViewModelFactory(
    private val db: RanPickDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RandomNumberViewModel::class.java)) {
            return RandomNumberViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}