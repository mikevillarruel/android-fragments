package com.example.fragments

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txtOutput)
        viewModel.getUser().observe(viewLifecycleOwner, Observer { user ->
            text.text = "${user.name} ${user.edad}"
        })

        findNavController().previousBackStackEntry?.savedStateHandle?.set("user",User("Julio",29))

        val button = view.findViewById<Button>(R.id.btnSendData)
        button.setOnClickListener {
            val result = "Result"
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            findNavController().navigate(Uri.parse("cursoandroid://card"))
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