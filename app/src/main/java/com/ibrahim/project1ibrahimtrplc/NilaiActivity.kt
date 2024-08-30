package com.ibrahim.project1ibrahimtrplc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class NilaiActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    /**
     * : -> extends (pewarisan/inherit)
     * , -> implements (interface)
     */

    val pilihanSKS = arrayOf<String>("2", "3", "4", "5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)

        val nama = findViewById<EditText>(R.id.editNama)
        val harian = findViewById<EditText>(R.id.editHarian)
        val uts = findViewById<EditText>(R.id.editUts)
        val uas = findViewById<EditText>(R.id.editUas)
        val proses = findViewById<Button>(R.id.btnProses)
        val outNilai = findViewById<TextView>(R.id.txtOutNilai)



        // Membuat object dan Men-setting adapter untuk spinner
        val sks = findViewById<Spinner>(R.id.spinSks)
        sks.onItemSelectedListener=this

        val aa:ArrayAdapter<*> = ArrayAdapter<Any?>(this@NilaiActivity, R.layout.spinner_style, pilihanSKS)
        aa.setDropDownViewResource(R.layout.spinner_style)
        sks.adapter = aa



        proses.setOnClickListener {
            val namaMhs = nama.text.toString()
            val jumlahSks = sks.selectedItem.toString()

            val nHarian = harian.text.toString().toFloat()
            val nUts = uts.text.toString().toFloat()
            val nUas = uas.text.toString().toFloat()
            val akhir = (nHarian * 0.4) + (nUts * 0.2) + (nUas * 0.4)

            outNilai.text = "Detil Nilai Mahasiswa" +
                    "\nNama Mahasiswa\t: $namaMhs" +
                    "\nNilai Harian\t: $nHarian" +
                    "\nNilai UTS\t: $nUts" +
                    "\nNilai UAS\t: $nUas" +
                    "\nJumlah SKS\t: $jumlahSks" +
                    "\nNilai Akhir\t: $akhir"
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}