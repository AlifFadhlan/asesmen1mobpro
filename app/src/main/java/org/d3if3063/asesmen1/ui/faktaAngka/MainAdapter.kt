package org.d3if3063.asesmen1.ui.faktaAngka

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.d3if3063.asesmen1.R
import org.d3if3063.asesmen1.databinding.ListAngkaBinding
import org.d3if3063.asesmen1.model.FunFact

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val data = mutableListOf<FunFact>()
    fun updateData(newData: List<FunFact>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(private val binding: ListAngkaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(funFact: FunFact) = with(binding) {
            namaTextView.text = funFact.nama
            deskripsiTextView.text = funFact.deskripsi
            imageView.setImageResource(funFact.imageResId)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, funFact.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListAngkaBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}