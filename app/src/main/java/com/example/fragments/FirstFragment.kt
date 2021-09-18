package com.example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

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
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment("Mike",25)
            findNavController().navigate(action)
        }
    }
}