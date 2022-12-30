package com.example.batika2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.batika2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = getColor(R.color.white)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        val loggedIn = sharedPref.getBoolean("LOGGED_IN", false)
        replaceFragment(EtalaseFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.etalase -> replaceFragment(EtalaseFragment())
                R.id.keranjang -> replaceFragment(KeranjangFragment())
                R.id.pesanan -> replaceFragment(PesananFragment())
                R.id.akun -> {
                    if (loggedIn) replaceFragment(AkunFragmentLoggedIn())
                    else replaceFragment(AkunFragment())
                }
                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}