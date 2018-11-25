package com.gusmas.indo.samplecoroutineroom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.gusmas.indo.samplecoroutineroom.adapter.ItemAdapter
import com.gusmas.indo.samplecoroutineroom.database.AppDatabase
import com.gusmas.indo.samplecoroutineroom.database.Barang
import kotlinx.android.synthetic.main.activity_list_barang.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class ListBarangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_barang)
        ambilData();
    }

    private fun ambilData() {
        async(UI){
            val data = bg {
                AppDatabase.getAppDatabase(this@ListBarangActivity)
                        .barangDao()
                        .allBarang
            }
            showData(data.await())
        }
    }

    private fun showData(await: List<Barang>) {
        list.adapter = ItemAdapter(await)
        list.layoutManager = LinearLayoutManager(this)
    }
}
