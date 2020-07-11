package com.example.prototypeselfquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_four.*
import kotlinx.android.synthetic.main.fragment_one.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

class FragmentFour : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_four, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_fragment_names_four.text = "Cough"
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {
            val sdf = SimpleDateFormat("ss.SSS")
            val currentDate = sdf.format(Date())
            val communicator:lCommunicator = activity as lCommunicator
            yes3.setOnClickListener {
                val clickDate = sdf.format(Date())
                val responseTime = clickDate.toFloat()-currentDate.toFloat()
                val decimal = BigDecimal(responseTime.toDouble()).setScale(3, RoundingMode.HALF_EVEN)
                response2.text = "ReponseTime: $decimal"
                communicator.getResponse2(decimal.toFloat())
                communicator.getMessage2(1)
            }
            no3.setOnClickListener {
                val clickDate = sdf.format(Date())
                val responseTime = clickDate.toFloat()-currentDate.toFloat()
                val decimal = BigDecimal(responseTime.toDouble()).setScale(3, RoundingMode.HALF_EVEN)
                response2.text = "ReponseTime: $decimal"
                communicator.getResponse2(decimal.toFloat())
                communicator.getMessage2(0)
            }
        }
    }
}