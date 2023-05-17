package org.d3if3063.asesmen1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3063.asesmen1.model.RandomNumber
import java.util.*

class RandomNumberViewModel : ViewModel() {
    val randomNumber = MutableLiveData<RandomNumber>()

    fun generateRandomNumber(maxNumber: Int) {
        val random = Random()
        val number = random.nextInt(maxNumber) + 1
        val randomNum = RandomNumber(maxNumber, number)
        randomNumber.value = randomNum
    }
}
