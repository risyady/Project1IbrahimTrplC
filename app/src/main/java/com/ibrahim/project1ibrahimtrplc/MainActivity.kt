package com.ibrahim.project1ibrahimtrplc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var nama:EditText
    lateinit var submit:Button
    lateinit var output:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nama = findViewById(R.id.editNama)
        submit = findViewById(R.id.btnSubmit)
        output = findViewById(R.id.txtOut)

        submit.setOnClickListener {
            output.text = "Data Mahasiswa" +
                    "\nNama Mahasiswa: " + nama.text.toString()
        }

    }
}