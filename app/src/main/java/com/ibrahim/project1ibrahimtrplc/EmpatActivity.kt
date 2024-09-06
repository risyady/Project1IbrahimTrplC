package com.ibrahim.project1ibrahimtrplc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EmpatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empat)

        val result = findViewById<TextView>(R.id.txtResult)
        val bundle = intent.extras

        if(bundle != null) {

            result.text = "Transaction" +
                    "\nProduct Name:\t ${bundle.getString("name")}" +
                    "\nPrice\t\t: ${bundle.getString("price")} ${bundle.getString("piece")}" +
                    "\nTotal\t\t: ${bundle.getString("total")}"
        }
    }
}