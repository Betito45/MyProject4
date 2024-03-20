package com.example.myproject4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextBillAmount = findViewById<EditText>(R.id.editTextBillAmount)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            // Get the bill amount from the EditText
            val billAmount = editTextBillAmount.text.toString().toDoubleOrNull()

            if (billAmount != null) {
                // Calculate the tip (you can adjust the tip percentage as needed)
                val tipPercentage = 0.15 // 15% tip
                val tipAmount = billAmount * tipPercentage

                // Format the tip amount to display properly
                val formattedTipAmount = DecimalFormat("#0.00").format(tipAmount)

                // Display the tip amount in the TextView
                textViewResult.text = getString(R.string.tip_amount, formattedTipAmount)
            } else {
                // If the user didn't enter a valid bill amount, display an error message
                textViewResult.text = getString(R.string.invalid_bill_amount)
            }
        }
    }
}