package com.example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnGo = view.findViewById<Button>(R.id.btnGo)
        val text = view.findViewById<TextView>(R.id.txtOutput)

        setFragmentResultListener("requestKey") { requestKey: String, bundle: Bundle ->
            val result = bundle.getString("bundleKey")
            text.text = result
        }

        btnGo.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragment_container_view, SecondFragment.newInstance("Mike", 25))
                addToBackStack("firstFragment")
            }
        }
    }
}