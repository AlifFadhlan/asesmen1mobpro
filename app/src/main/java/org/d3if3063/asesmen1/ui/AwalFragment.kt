package org.d3if3063.asesmen1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.d3if3063.asesmen1.R
import org.d3if3063.asesmen1.databinding.FragmentAwalBinding

class AwalFragment : Fragment() {
    private lateinit var binding: FragmentAwalBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentAwalBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonMasuk.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_awalFragment_to_randomPickerFragment
            )
        }
    }
}