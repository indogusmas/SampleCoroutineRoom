package com.gusmas.indo.samplecoroutineroom.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gusmas.indo.samplecoroutineroom.R
import com.gusmas.indo.samplecoroutineroom.database.Barang
import kotlinx.android.synthetic.main.itemlist.view.*

class ItemAdapter(var data: List<Barang>): RecyclerView.Adapter<ItemAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
         return  MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false));
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data[position])
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: Barang) {
            itemView.textName.text = get.name
            itemView.textDeskripsi.text = get.desk
        }

    }
}