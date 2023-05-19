package org.d3if3063.asesmen1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RanPickEntity::class], version = 2, exportSchema = false)
abstract class RanPickDb : RoomDatabase() {
    abstract val dao: RanPickDao
    companion object {
        @Volatile
        private var INSTANCE: RanPickDb? = null
        fun getInstance(context: Context): RanPickDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RanPickDb::class.java,
                        "ranpick.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
