package org.d3if3063.asesmen1.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ranPick")
data class RanPickEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var maxNumber: Int,
    var number: Int
)