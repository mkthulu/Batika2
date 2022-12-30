package com.example.batika2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KeranjangAdapter : RecyclerView.Adapter<KeranjangAdapter.ViewHolder>() {
    var dataList = emptyList<KeranjangModel>()

    internal fun setDataList(dataList: List<KeranjangModel>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var gambar: ImageView
        var nama: TextView
        var harga: TextView
        var total: TextView

        init {
            gambar = itemView.findViewById(R.id.produk_gambar)
            nama = itemView.findViewById(R.id.produk_nama)
            harga = itemView.findViewById(R.id.produk_harga)
            total = itemView.findViewById(R.id.produk_total)
        }
    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Inflate the custom layout
        var view = LayoutInflater.from(parent.context).inflate(R.layout.frame_keranjang, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.nama.text = data.produkModel.nama
        holder.harga.text = "Rp ${data.produkModel.harga},-   ( x ${data.jumlah} )"
        holder.total.text = "Rp ${data.produkModel.harga * data.jumlah},-"

        holder.gambar.setImageResource(data.produkModel.gambar)
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}