package org.d3if3063.asesmen1.ui.histori


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3063.asesmen1.databinding.ItemHistoriBinding
import org.d3if3063.asesmen1.db.RanPickEntity
import org.d3if3063.asesmen1.model.generateRandomNumber
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter :
    ListAdapter<RanPickEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<RanPickEntity>() {
                override fun areItemsTheSame(
                    oldData: RanPickEntity, newData: RanPickEntity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun areContentsTheSame(
                    oldData: RanPickEntity, newData: RanPickEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }
    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID")
        )
        fun bind(item: RanPickEntity) = with(binding) {
            val maxNum = item.maxNumber
            val hasilNum = item.number
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            maxTextView.text = "Max : $maxNum"
            dataTextView.text= "Hasil : $hasilNum"
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}