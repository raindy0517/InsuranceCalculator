package com.example.insurancecalculator

import android.icu.util.CurrencyAmount
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long) {
        /*Toast.makeText(this, "Position = $position",
            Toast.LENGTH_SHORT).show()*/

        Toast.makeText(this,"Item = $(spinnerAge.getItemAtPosition(Position))",
            Toast.LENGTH_SHORT).show();

        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Associate spinner to the Main Activity
        spinnerAge.onItemSelectedListener = this

        buttonCalculate.setOnClickListener {
            calculatePremium()
        }
    }

    private fun calculatePremium() {
        //TODO calculate insurance premium

        var premium : Int = 0
        val symbol = Currency.getInstance(Locale.getDefault()).symbol

        //position = index of an selectd by user
        val age: Int = spinnerAge.selectedItemPosition
            premium += when(age){
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                else -> 150

            }

        //ID of a radioButton checked by user
        val gender: Int = radioGroupGender.checkedRadioButtonId
        if(gender == R.id.radioButtonMale){
            premium += when(age) {
                0 -> 0
                1 -> 50
                2 -> 100
                3 -> 150
                else -> 200

            }
        }
        else{
            premium += 0
        }

        //Boolean value
        val smoker: Boolean = checkBox.isChecked
        if(smoker){
            premium += when(age){
                0 -> 0
                1 -> 100
                2 -> 150
                3 -> 200
                4 -> 250
                else -> 300
            }
        }

        textViewPremium.text = String.format("%s %d",symbol, premium)

    }

    fun resetInput(view: View?){
        //TODO clear all input and outputs

        textViewPremium.text = ""
        radioGroupGender.clearCheck()
        spinnerAge.setSelection(0)
    }
}
