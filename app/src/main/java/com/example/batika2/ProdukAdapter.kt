package com.example.batika2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProdukAdapter : RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {
    var dataList = emptyList<ProdukModel>()

    internal fun setDataList(dataList: List<ProdukModel>) {
        this.dataList = dataList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var gambar: ImageView
        var nama: TextView
        var harga: TextView
        init {
            gambar = itemView.findViewById(R.id.produk_gambar)
            nama = itemView.findViewById(R.id.produk_nama)
            harga = itemView.findViewById(R.id.produk_harga)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.frame_produk, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = dataList[position]
        holder.nama.text = data.nama
        holder.harga.text = "Rp ${data.harga}"
        holder.gambar.setImageResource(data.gambar)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProdukActivity::class.java).apply {
                putExtra("PRODUK_ID", data.id)
                putExtra("PRODUK_GAMBAR", data.gambar)
                putExtra("PRODUK_NAMA", data.nama)
                putExtra("PRODUK_HARGA", data.harga)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataList.size
}