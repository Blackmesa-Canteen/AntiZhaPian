package com.demo.antizha.ui.mine

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.demo.antizha.PersonalActivity
import com.demo.antizha.R
import com.demo.antizha.SettingActivity

class MineFragment : Fragment() {

    private lateinit var mineViewModel: MineViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mineViewModel =
            ViewModelProvider(this).get(MineViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_mine, container, false)
        val phoneNumber: TextView = root.findViewById(R.id.phone_number)
        phoneNumber.text = getMyPhoneNumber()
        val personalInfo: TextView = root.findViewById(R.id.more_info)
        val mineSetting: ImageView = root.findViewById(R.id.mine_setting)
        personalInfo.setOnClickListener {
            val intentInfo = Intent(activity, PersonalActivity::class.java)
            startActivity(intentInfo)
        }
        mineSetting.setOnClickListener {
            val intentSetting = Intent(activity, SettingActivity::class.java)
            startActivity(intentSetting)
        }
        return root
    }


    private fun getMyPhoneNumber() : String {
        val settings: SharedPreferences = requireActivity().getSharedPreferences("setting", 0)
        val originalNum = settings.getString("phone", "13901").toString()
        val a = originalNum.substring(0..2)
        val b = "******"
        val c = originalNum.substring(3..4)

        val head = getString(R.string.title_mine)

        // 我的手机号
        return "$head  $a$b$c"
    }

    private fun generatePhoneNumber(): String {   //手机号生成
        val head = getString(R.string.title_mine)
        val a = listOf(
            131,
            132,
            133,
            134,
            135,
            136,
            137,
            138,
            139,
            177,
            151,
            152,
            153,
            155,
            156
        ).random().toString()
        val b = "******"
        val c = (10..99).random().toString()
        return "$head  $a$b$c"
    }
}