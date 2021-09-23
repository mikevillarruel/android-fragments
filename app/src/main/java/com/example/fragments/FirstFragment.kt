package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment(R.layout.fragment_first) {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnGo = view.findViewById<Button>(R.id.btnGo)
        val text = view.findViewById<TextView>(R.id.txtOutput)

        setFragmentResultListener("requestKey") { requestKey: String, bundle: Bundle ->
            val result = bundle.getString("bundleKey")
            text.text = result
        }

        btnGo.setOnClickListener {
            viewModel.setUser(User("Mike", 25))
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<User>("user")
            ?.observe(viewLifecycleOwner) { result ->
                Log.d("User", result.toString())
            }
    }
}