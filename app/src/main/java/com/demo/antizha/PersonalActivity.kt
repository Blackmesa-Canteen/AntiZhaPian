package com.demo.antizha

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.antizha.databinding.PersonalInfoBinding

class PersonalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val infoBinding = PersonalInfoBinding.inflate(layoutInflater)
        setContentView(infoBinding.root)
        val settings: SharedPreferences = getSharedPreferences("setting", 0)

        infoBinding.name.text = settings.getString("name", "习** ")
        infoBinding.id.text = settings.getString("id", "6****************1")
        infoBinding.region.text = settings.getString("region", "陕西省.富平市.延川县")
        infoBinding.address.text = settings.getString("address", "安驿公社梁家河大队")
        infoBinding.work.text = settings.getString("work", "党政机关、社会团体")
    }
}