package com.vitalyv.tiptime2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vitalyv.tiptime2.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculate.setOnClickListener {
            clickOn()
        }

    }

    fun clickOn() {

        var cost = binding.costOfService.text.toString().toDouble()

        var selectVariantGrade = binding.containerButon.checkedRadioButtonId
        var tipPercentage = when (selectVariantGrade) {
            R.id.goodButton -> 0.18
            R.id.amazingButton -> 0.20
            else -> 0.15
        }
        var tip = cost * tipPercentage
        val roundVal = binding.roundUpTipSwitch.isChecked
        if (roundVal) {
            tip = Math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.result.text = getString(R.string.tip_amount, formattedTip)

    }
}