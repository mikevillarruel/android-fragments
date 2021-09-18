package com.example.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var name: String? = ""
    private var age: Int? = 0
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = args.name
        age = args.age
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txtOutput)
        text.text = "$name $age"
        val button = view.findViewById<Button>(R.id.btnSendData)
        button.setOnClickListener {
            val result = "Result"
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
    }

    companion object {
        private const val NAME = "name"
        private const val AGE = "age"

        fun newInstance(name: String, age: Int) = SecondFragment().apply {
            arguments = bundleOf(NAME to name, AGE to age)
        }
    }

}