package org.d3if3063.asesmen1.ui.random

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3063.asesmen1.db.RanPickDao
import org.d3if3063.asesmen1.db.RanPickEntity
import org.d3if3063.asesmen1.model.RandomNumber
import org.d3if3063.asesmen1.model.generateRandomNumber
import java.util.*

class RandomNumberViewModel(private val db: RanPickDao) : ViewModel() {
    val randomNumber = MutableLiveData<RandomNumber>()
    fun doGenerate(maxNumber: Int){
        val random = Random()
        val number = random.nextInt(maxNumber) + 1
//        val randomNum = RandomNumber(maxNumber, number)
        generateRandomNumber(maxNumber, number)
    }
    fun generateRandomNumber(maxNumber: Int, number: Int) {
//        val random = Random()
//        val number = random.nextInt(maxNumber) + 1
//        val randomNum = RandomNumber(maxNumber, number)
//        randomNumber.value = randomNum
        val dataRanPick = RanPickEntity(
            maxNumber = maxNumber,
            number = number
        )
        randomNumber.value = dataRanPick.generateRandomNumber()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
//                val dataRanPick = RanPickEntity(
//                    maxNumber = maxNumber,
//                    number = number
//                )
                db.insert(dataRanPick)
            }
        }
    }
}
