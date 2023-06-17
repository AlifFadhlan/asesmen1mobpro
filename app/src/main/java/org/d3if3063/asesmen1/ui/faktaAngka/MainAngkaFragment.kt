package org.d3if3063.asesmen1.ui.faktaAngka

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if3063.asesmen1.model.FunFact
import org.d3if3063.asesmen1.R
import org.d3if3063.asesmen1.databinding.FragmentMainBinding

class MainAngkaFragment : Fragment() {
    private val viewModel: MainAngkaViewModel by lazy {
        ViewModelProvider(this)[MainAngkaViewModel::class.java]
    }
    private lateinit var binding: FragmentMainBinding
    private lateinit var myAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        myAdapter = MainAdapter()
        with(binding.recyclerView) {
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    RecyclerView.VERTICAL
                )
            )
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner) {
            myAdapter.updateData(it)
        }
    }
}
