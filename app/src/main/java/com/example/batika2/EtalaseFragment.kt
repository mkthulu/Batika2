package com.example.batika2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.batika2.databinding.FragmentEtalaseBinding

class EtalaseFragment : Fragment() {
    private var _binding : FragmentEtalaseBinding? = null
    private val binding get() = _binding!!
    private lateinit var produkAdapter : ProdukAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEtalaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false;
        }
        val dataList = mutableListOf<ProdukModel>()
        binding.etalaseRecyclerView.layoutManager = GridLayoutManager(activity,2)
        produkAdapter = ProdukAdapter()
        binding.etalaseRecyclerView.adapter = produkAdapter
        dataList.removeAll(dataList)
        dataList.add(ProdukModel(1, R.drawable.produk_1, "Syal Batik", 60000.00F))
        dataList.add(ProdukModel(2, R.drawable.produk_2, "Tas Batik", 75000.00F))
        dataList.add(ProdukModel(3, R.drawable.produk_3, "Baju Batik Pria", 90000.00F))
        dataList.add(ProdukModel(4, R.drawable.produk_4, "Baju Batik Wanita", 95000.00F))
        dataList.add(ProdukModel(5, R.drawable.produk_5, "Backpack Batik", 80000.00F))
        produkAdapter.setDataList(dataList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}