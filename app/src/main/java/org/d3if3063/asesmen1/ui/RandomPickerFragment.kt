package org.d3if3063.asesmen1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import org.d3if3063.asesmen1.databinding.FragmentRandomPickerBinding


class RandomPickerFragment : Fragment() {
    private lateinit var binding: FragmentRandomPickerBinding

    private val viewModel: RandomNumberViewModel by lazy {
        ViewModelProvider(requireActivity())[RandomNumberViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentRandomPickerBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener{
            val maxNumberString = binding.maxNumberEditText.text.toString()
            if (maxNumberString.isNotEmpty()) {
                val maxNumber = maxNumberString.toInt()
                viewModel.generateRandomNumber(maxNumber)
            }
            else {
                Toast.makeText(context, "Please enter a valid number.", Toast.LENGTH_SHORT).show()
            }

        }
        viewModel.randomNumber.observe(requireActivity(), Observer {randomNumber ->
            val displayText = "Max Number: ${randomNumber.maxNumber}\nNumber: ${randomNumber.number}"
            binding.numberTextView.text = displayText
        })
    }
}