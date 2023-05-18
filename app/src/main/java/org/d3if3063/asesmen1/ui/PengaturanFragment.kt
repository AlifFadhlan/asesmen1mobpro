package org.d3if3063.asesmen1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if3063.asesmen1.R
import org.d3if3063.asesmen1.databinding.FragmentPengaturanBinding

class PengaturanFragment : Fragment()
{
    private lateinit var binding: FragmentPengaturanBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentPengaturanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textUI()
    }

    private fun textUI(){
        binding.textViewDesc.text = getText(R.string.pengaturan_decs)
        binding.textViewJudul.text = getText(R.string.pengaturan)
    }

}
