package com.example.coffeed19.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coffeed19.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_menu.view.*

class MenuFragment : Fragment() {

    var displayMassage: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        displayMassage = arguments?.getString("massage")

        view.displayMassage.text = displayMassage

        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

}