package com.example.prototypeselfquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_six.*
import kotlinx.android.synthetic.main.fragment_two.*
import java.io.FileWriter
import java.security.Timestamp
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import kotlin.math.round
import java.math.BigDecimal
import java.math.RoundingMode

class FragmentSix : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_six, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_fragment_names_six.text = "Loss of Appetite"
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {
            val sdf = SimpleDateFormat("ss.SSS")
            val currentDate = sdf.format(Date())
            val communicator:lCommunicator = activity as lCommunicator
            yes5.setOnClickListener {
                val clickDate = sdf.format(Date())
                val responseTime = clickDate.toFloat()-currentDate.toFloat()
                val decimal = BigDecimal(responseTime.toDouble()).setScale(3, RoundingMode.HALF_EVEN)
                response4.text = "ReponseTime: $decimal"
                communicator.getResponse4(decimal.toFloat())
                communicator.getMessage4(1)
            }
            no5.setOnClickListener {
                val clickDate = sdf.format(Date())
                val responseTime = clickDate.toFloat()-currentDate.toFloat()
                val decimal = BigDecimal(responseTime.toDouble()).setScale(3, RoundingMode.HALF_EVEN)
                response4.text = "ReponseTime: $decimal"
                communicator.getResponse4(decimal.toFloat())
                communicator.getMessage4(0)
            }
        }
    }
}