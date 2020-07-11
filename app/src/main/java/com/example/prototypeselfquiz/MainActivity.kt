package com.example.prototypeselfquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileWriter
import java.util.ArrayList

class MainActivity : AppCompatActivity(), lCommunicator {

    var achespains = 0
    var breathing = 0
    var Coughing = 0
    var fatigue = 0
    var LossOfAppetite = 0
    var taste = 0

    var achestime = 0.0
    var breathingtime = 0.0
    var coughtime = 0.0
    var fatiguetime = 0.0
    var appetitetime = 0.0
    var tastetime = 0.0

    var submit = 0

    val TAG="MainActivity"

    override fun getMessage(msg: Int) {
        achespains = msg
    }

    override fun getResponse(msg: Float) {
        achestime = msg.toDouble()
        var file = FileWriter(
            File(applicationContext.getExternalFilesDir(null), "locations.txt"),
            true)
        if (File(applicationContext.getExternalFilesDir(null), "locations.txt").exists()) {
            file.write("ho")
            file.close()
        }
    }

    override fun getMessage1(msg: Int) {
        breathing = msg
    }

    override fun getResponse1(msg: Float) {
        breathingtime = msg.toDouble()
    }

    override fun getMessage2(msg: Int) {
        Coughing = msg
    }

    override fun getResponse2(msg: Float) {
        coughtime = msg.toDouble()
    }

    override fun getMessage3(msg: Int) {
        fatigue = msg
    }

    override fun getResponse3(msg: Float) {
        fatiguetime = msg.toDouble()
    }

    override fun getMessage4(msg: Int) {
        LossOfAppetite = msg
    }

    override fun getResponse4(msg: Float) {
        appetitetime = msg.toDouble()
    }

    override fun getMessage5(msg: Int) {
        taste = msg
    }

    override fun getResponse5(msg: Float) {
        tastetime = msg.toDouble()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Self-Assessment")

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentOne() , " One ")
        adapter.addFragment(FragmentTwo() , " Two ")
        adapter.addFragment(FragmentThree(), " Three ")
        adapter.addFragment(FragmentFour() , " Four ")
        adapter.addFragment(FragmentFive(), " Five ")
        adapter.addFragment(FragmentSix(), " Six ")
        adapter.addFragment(FragmentSeven(), " Seven ")
        viewPager.adapter = adapter



    }

    class MyViewPagerAdapter (manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()


        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}