package com.example.batika2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class AkunFragmentLoggedIn : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_akun_logged_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = this.activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        view.findViewById<Button>(R.id.btn_logout).setOnClickListener {
            with (sharedPref.edit()) {
                putString("USERNAME", null)
                putBoolean("LOGGED_IN", false)
                apply()
            }
            replaceFragment(AkunFragment())
        }
        view.findViewById<Button>(R.id.btn_profil).setOnClickListener {
            val intent = Intent(this.context, AkunPengaturanActivity::class.java)
            this.startActivity(intent)
        }
        if (!sharedPref.getBoolean("LOGGED_IN", false)) {
            replaceFragment(AkunFragment())
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