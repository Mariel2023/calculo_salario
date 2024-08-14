package com.example.calculadorasalarial

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val salaryEditText = findViewById<EditText>(R.id.salaryEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val baseSalary = salaryEditText.text.toString().toDouble()

            val employee = Employee(name, baseSalary)
            val result = employee.getDeductionsDetail()

            resultTextView.text = result
        }
    }
}
