package com.example.coffeed19.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.coffeed19.Communicator
import com.example.coffeed19.R
import com.inyongtisto.tutorial.adapter.AdapterSlider
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        
        communicator = activity as Communicator
        
        view.btn_pesan.setOnClickListener{
            communicator.passDataCom(view.massageInput.text.toString())
        }

        vpSlider = view.findViewById(R.id.vp_slider1)
        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.tugas1)
        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

        return view

    }

}
