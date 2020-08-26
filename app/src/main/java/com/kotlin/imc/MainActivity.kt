package com.kotlin.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Please complete the fields!", Toast.LENGTH_LONG).show()

        btnCalculate.setOnClickListener {
            if(etWeight.text.toString() != "" && etHeight.text.toString() != ""){
                calculateBmi(etWeight.text.toString(),  etHeight.text.toString())
            } else {
                Toast.makeText(this, "Please complete the fields!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun calculateBmi(peso:String, altura:String){

        val m = altura.toFloat() / 100
        val bmi = (peso.toFloat() / (m * m))

        if(m != null && bmi != null){
            if (bmi < 18.5) {
                tvValueBmi.text = "BMI: " + " " +"%.1f".format(bmi)
                tvCategoryBmi.text = "Category: Slim"
            } else
                if (bmi < 24.9) {
                    tvValueBmi.text = "BMI: " + " " + "%.1f".format(bmi)
                    tvCategoryBmi.text = "Category: Normal"
                } else
                    if (bmi < 29.9) {
                        tvValueBmi.text = "BMI: "+ " " +"%.1f".format(bmi)
                        tvCategoryBmi.text = "Category: Overweight"
                    } else
                        if (bmi > 30) {
                            tvValueBmi.text = "BMI: "+ " " +"%.1f".format(bmi)
                            tvCategoryBmi.text = "Category: Obese"
                        }

        }
        }



}
