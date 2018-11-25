package com.gusmas.indo.samplecoroutineroom.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "barang")
class Barang {

    @PrimaryKey(autoGenerate = true)
    var id: Int =0

    @ColumnInfo(name ="name")
    var name: String? = null

    @ColumnInfo(name = "deskripsi")
    var desk: String? = null

}