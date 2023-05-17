package org.d3if3063.asesmen1.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.d3if3063.asesmen1.databinding.ActivityMainBinding
import org.d3if3063.asesmen1.viewmodel.RandomNumberViewModel
import androidx.lifecycle.Observer
import org.d3if3063.asesmen1.model.RandomNumber


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RandomNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(RandomNumberViewModel::class.java)

        binding.button.setOnClickListener{
            val maxNumberString = binding.maxNumberEditText.text.toString()
            if (maxNumberString.isNotEmpty()) {
                val maxNumber = maxNumberString.toInt()
                viewModel.generateRandomNumber(maxNumber)
            }
            else {
                Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show()
            }

        }
        viewModel.randomNumber.observe(this, Observer {randomNumber ->
            val displayText = "Max Number: ${randomNumber.maxNumber}\nNumber: ${randomNumber.number}"
            binding.numberTextView.text = displayText
        })
    }
}