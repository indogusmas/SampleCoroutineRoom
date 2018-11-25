package com.gusmas.indo.samplecoroutineroom

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gusmas.indo.samplecoroutineroom.database.AppDatabase
import com.gusmas.indo.samplecoroutineroom.database.Barang
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnInsert.setOnClickListener{
            if (itemNama.text.isNotEmpty() && itemDesk.text.isNotEmpty()){
                async(UI){
                    bg {
                        val name = itemNama.text.toString()
                        val desk  = itemDesk.text.toString()
                        var barang = Barang()
                        barang.name = name
                        barang.desk = desk
                        AppDatabase.getAppDatabase(this@MainActivity)
                                .barangDao()
                                .insertAll(barang)
                    }
                }
                startActivity(Intent(this, ListBarangActivity::class.java))
            }
        }
    }
}
