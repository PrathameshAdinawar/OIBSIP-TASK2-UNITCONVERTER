package com.example.unit_converter_app

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var textViewResult: TextView

    private val units = arrayOf("Inches", "Feet", "Yards", "Miles", "Millimeters", "Centimeters", "Meters", "Kilometers")
    private val conversionFactors = mapOf(
        Pair("Inches", "Feet") to 1.0 / 12,
        Pair("Inches", "Yards") to 1.0 / 36,
        Pair("Inches", "Miles") to 1.0 / 63360,
        Pair("Inches", "Millimeters") to 25.4,
        Pair("Inches", "Centimeters") to 2.54,
        Pair("Inches", "Meters") to 0.0254,
        Pair("Inches", "Kilometers") to 0.0000254,
        Pair("Feet", "Inches") to 12.0,
        Pair("Feet", "Yards") to 1.0 / 3,
        Pair("Feet", "Miles") to 1.0 / 5280,
        Pair("Feet", "Millimeters") to 304.8,
        Pair("Feet", "Centimeters") to 30.48,
        Pair("Feet", "Meters") to 0.3048,
        Pair("Feet", "Kilometers") to 0.0003048,
        Pair("Yards", "Inches") to 36.0,
        Pair("Yards", "Feet") to 3.0,
        Pair("Yards", "Miles") to 1.0 / 1760,
        Pair("Yards", "Millimeters") to 914.4,
        Pair("Yards", "Centimeters") to 91.44,
        Pair("Yards", "Meters") to 0.9144,
        Pair("Yards", "Kilometers") to 0.0009144,
        Pair("Miles", "Inches") to 63360.0,
        Pair("Miles", "Feet") to 5280.0,
        Pair("Miles", "Yards") to 1760.0,
        Pair("Miles", "Millimeters") to 1609344.0,
        Pair("Miles", "Centimeters") to 160934.4,
        Pair("Miles", "Meters") to 1609.344,
        Pair("Miles", "Kilometers") to 1.609344,
        Pair("Millimeters", "Inches") to 1.0 / 25.4,
        Pair("Millimeters", "Feet") to 1.0 / 304.8,
        Pair("Millimeters", "Yards") to 1.0 / 914.4,
        Pair("Millimeters", "Miles") to 1.0 ,
        Pair("Meters", "Inches") to 39.3701,
        Pair("Meters", "Feet") to 3.28084,
        Pair("Meters", "Yards") to 1.09361,
        Pair("Meters", "Miles") to 0.000621371,
        Pair("Meters", "Millimeters") to 1000.0,
        Pair("Meters", "Centimeters") to 100.0,
        Pair("Meters", "Kilometers") to 0.001,
        Pair("Kilometers", "Inches") to 39370.1,
        Pair("Kilometers", "Feet") to 3280.84,
        Pair("Kilometers", "Yards") to 1093.61,
        Pair("Kilometers", "Miles") to 0.621371,
        Pair("Kilometers", "Millimeters") to 1000000.0,
        Pair("Kilometers", "Centimeters") to 100000.0,
        Pair("Kilometers", "Meters") to 1000.0,
        Pair("Centimeters", "Inches") to 0.393701,
        Pair("Centimeters", "Feet") to 0.0328084,
        Pair("Centimeters", "Yards") to 0.0109361,
        Pair("Centimeters", "Miles") to 0.00000621371,
        Pair("Centimeters", "Millimeters") to 10.0,
        Pair("Centimeters", "Meters") to 0.01,
        Pair("Centimeters", "Kilometers") to 0.00001
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        spinnerFrom = findViewById(R.id.spinnerFrom)
        spinnerTo = findViewById(R.id.spinnerTo)
        textViewResult = findViewById(R.id.textViewResult)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter
    }

    fun convert(view: View) {
        val fromUnit = spinnerFrom.selectedItem.toString()
        val toUnit = spinnerTo.selectedItem.toString()
        val value = editText.text.toString().toDouble()
        val conversionFactor = conversionFactors[Pair(fromUnit, toUnit)] ?: 1.0
        val result = value * conversionFactor

        textViewResult.text = result.toString()
    }
}


           
