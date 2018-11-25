package com.gusmas.indo.samplecoroutineroom.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(Barang::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract  fun  barangDao(): BarangDao

    companion object {
        var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase {
            INSTANCE =  Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "db_barang")
                    .allowMainThreadQueries().build()
            return INSTANCE as AppDatabase
        }
    }

}