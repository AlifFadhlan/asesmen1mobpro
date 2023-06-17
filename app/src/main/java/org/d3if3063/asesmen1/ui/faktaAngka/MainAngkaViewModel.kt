package org.d3if3063.asesmen1.ui.faktaAngka

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3063.asesmen1.R
import org.d3if3063.asesmen1.model.FunFact

class MainAngkaViewModel : ViewModel() {
    private val data = MutableLiveData<List<FunFact>>()

    init {
        data.value = initData()
    }

    private fun initData(): List<FunFact> {
        return listOf(
            FunFact("Satu", "Lebar rel kereta api normal adalah 1 meter.", R.drawable.angka1),
            FunFact(
                "Dua",
                "Alat transportasi, seperti sepeda, sepeda motor, delman, gerobak, dan pedati berjumlahkan dua buah roda.",
                R.drawable.angka2
            ),
            FunFact("Tiga", "Warna pada lampu lalu lintas.", R.drawable.angka3),
            FunFact(
                "Empat", "Arah mata angin utama (utara, selatan, barat, dan timur).",
                R.drawable.angka4
            ),
            FunFact("Lima", "Alat indra pada tubuh manusia.", R.drawable.angka5),
            FunFact("Enam", "Jumlah senar pada gitar.", R.drawable.angka6),
            FunFact(
                "Tujuh",
                "Jumlah huruf yang dipergunakan dalam angka Romawi (yaitu: C, D, I, L, M, V, dan X).",
                R.drawable.angka7
            ),
            FunFact("Delapan", "Basis bilangan oktal.", R.drawable.angka8),
            FunFact("Sembilan", "Nomor atom Fluorin.", R.drawable.angka9),
            FunFact(
                "Nol",
                "Angka nol memainkan peranan penting dalam matematika sebagai identitas tambahan bagi bilangan bulat, bilangan real, dan struktur aljabar lainnya.",
                R.drawable.angka0
            ),
        )
    }
    fun getData(): LiveData<List<FunFact>> = data

}