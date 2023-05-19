package org.d3if3063.asesmen1.ui.histori

import androidx.lifecycle.ViewModel
import org.d3if3063.asesmen1.db.RanPickDao

class HistoriViewModel(db: RanPickDao) : ViewModel() {
    val data = db.getLastPick()
}
