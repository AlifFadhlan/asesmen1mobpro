package org.d3if3063.asesmen1.ui.random

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.d3if3063.asesmen1.R
import org.d3if3063.asesmen1.databinding.FragmentRandomPickerBinding
import org.d3if3063.asesmen1.db.RanPickDb


class RandomPickerFragment : Fragment() {
    private lateinit var binding: FragmentRandomPickerBinding

    private val viewModel: RandomNumberViewModel by lazy {
        val db = RanPickDb.getInstance(requireContext())
        val factory = RandomViewModelFactory(db.dao)
        ViewModelProvider(this,factory)[RandomNumberViewModel::class.java]
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentRandomPickerBinding.inflate(layoutInflater, container,false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener{
            val maxNumberString = binding.maxNumberEditText.text.toString()
            if (maxNumberString.isNotEmpty()) {
                val maxNumber = maxNumberString.toInt()
                viewModel.doGenerate(maxNumber)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_bagikan -> {
                shareData()
            }

            R.id.menu_about -> {
                findNavController().navigate(
                    R.id.action_randomPickerFragment_to_aboutFragment
                )
                return true
            }
            R.id.menu_histori -> {
                findNavController().navigate(
                    R.id.action_randomPickerFragment_to_historiFragment
                )
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareData() {
        val message = getString(R.string.bagikan_template)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }
    }
}