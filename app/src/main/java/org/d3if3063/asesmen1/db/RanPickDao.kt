package org.d3if3063.asesmen1.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RanPickDao {

    @Insert
    fun insert(ranpick: RanPickEntity)

    @Query("SELECT * FROM ranpick ORDER BY id DESC LIMIT 1")
    fun getLastPick(): LiveData<RanPickEntity?>
}