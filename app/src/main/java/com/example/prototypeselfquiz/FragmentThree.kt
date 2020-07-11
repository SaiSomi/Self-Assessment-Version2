package com.example.prototypeselfquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.fragment_three.*
import kotlinx.android.synthetic.main.fragment_two.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

class FragmentThree : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_fragment_names_three.text = "Difficulty Breathing"

    }
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {
            val sdf = SimpleDateFormat("ss.SSS")
            val currentDate = sdf.format(Date())
            val communicator:lCommunicator = activity as lCommunicator
            yes2.setOnClickListener {
                val clickDate = sdf.format(Date())
                val responseTime = clickDate.toFloat()-currentDate.toFloat()
                val decimal = BigDecimal(responseTime.toDouble()).setScale(3, RoundingMode.HALF_EVEN)
                response1.text = "ResponseTime: $decimal"
                communicator.getResponse1(decimal.toFloat())
                communicator.getMessage1(1)
            }
            no2.setOnClickListener {
                val clickDate = sdf.format(Date())
                val responseTime = clickDate.toFloat()-currentDate.toFloat()
                val decimal = BigDecimal(responseTime.toDouble()).setScale(3, RoundingMode.HALF_EVEN)
                response1.text = "ResponseTime: $decimal"
                communicator.getResponse1(decimal.toFloat())
                communicator.getMessage1(0)
            }
        }
    }
}
