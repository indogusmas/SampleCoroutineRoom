package com.gusmas.indo.samplecoroutineroom.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


@Dao
interface BarangDao {

    @Insert
    fun insertAll(barang: Barang)

    @Delete
    fun delete(barang: Barang)

    @get:Query("select * from barang")
    val allBarang: List<Barang>

}