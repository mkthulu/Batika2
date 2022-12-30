package com.example.batika2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class AkunFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_akun, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = this.activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            with(sharedPref.edit()) {
                putString("USERNAME", "pelanggan")
                putBoolean("LOGGED_IN", true)
                apply()
            }
            replaceFragment(AkunFragmentLoggedIn())
        }
        if (sharedPref.getBoolean("LOGGED_IN", false)) {
            replaceFragment(AkunFragmentLoggedIn())
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = this.activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        if (fragmentTransaction != null) {
            fragmentTransaction.replace(R.id.frameLayout, fragment)
            fragmentTransaction.commit()
        }
    }
}