package com.example.batika2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batika2.databinding.ActivityProdukBinding

class ProdukActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProdukBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.produkNama.text = intent.getStringExtra("PRODUK_NAMA")
        binding.produkGambar.setImageResource(intent.getIntExtra("PRODUK_GAMBAR", R.drawable.ic_launcher_background))
        binding.produkStok.text = intent.getIntExtra("PRODUK_STOK", 0).toString()
        val harga = intent.getFloatExtra("PRODUK_HARGA", 100000.0f)
        binding.produkHarga.text = harga.toString()
        binding.produkTotal.text = harga.toString()
        var jumlah = 1;
        binding.etJumlah.setText(jumlah.toString())
        binding.btnKurangJumlah.setOnClickListener {
            if (jumlah > 1) {
                jumlah--
                binding.etJumlah.setText(jumlah.toString())
                binding.produkTotal.text = (harga*jumlah).toString()
            }
        }
        binding.btnTambahJumlah.setOnClickListener {
            jumlah++
            binding.etJumlah.setText(jumlah.toString())
            binding.produkTotal.text = (harga*jumlah).toString()
        }
    }
}