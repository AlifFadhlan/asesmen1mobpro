package org.d3if3063.asesmen1

import android.R
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.d3if3063.asesmen1.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { generateRandomNumber() }
    }
    private fun generateRandomNumber() {
        val maxNumberString = binding.maxNumberEditText.text.toString()

        if(maxNumberString.isNotEmpty()) {
            val maxNumber = maxNumberString.toInt()
            val random = Random()
            val number = random.nextInt(maxNumber) + 1
            binding.numberTextView.text = "Random Number:\n" + number.toString()
        }
        else {
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show()
        }
    }
}