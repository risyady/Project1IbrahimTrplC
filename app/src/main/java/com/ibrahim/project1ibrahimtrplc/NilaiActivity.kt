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

    lateinit var rbBeasiswa:RadioButton

    val pilihanSKS = arrayOf<String>("2", "3", "4", "5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)

        val nama = findViewById<EditText>(R.id.editNama)
        val harian = findViewById<EditText>(R.id.editHarian)
        val uts = findViewById<EditText>(R.id.editUts)
        val uas = findViewById<EditText>(R.id.editUas)
        val outNilai = findViewById<TextView>(R.id.txtOutNilai)
        val beasiswa = findViewById<RadioGroup>(R.id.rgBeasiswa)

        // Membuat object dan Men-setting adapter untuk spinner
        val sks = findViewById<Spinner>(R.id.spinSks)
        sks.onItemSelectedListener=this

        val pembangunan = findViewById<CheckBox>(R.id.chkPembangunan)
        val semester = findViewById<CheckBox>(R.id.chkSemester)
        val diklat = findViewById<CheckBox>(R.id.chkDiklat)
        val proses = findViewById<Button>(R.id.btnProses)

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

            val uang = StringBuffer()
            var totalSPP:Int=0

            if(pembangunan.isChecked) {
                uang.append("\n\t\tUang Pembangunan: Rp. 1.000.000")
                totalSPP += 1000000
            }

            if(semester.isChecked) {
                uang.append("\n\t\tUang Semester: Rp. 2.000.000")
                totalSPP += 2000000
            }

            if(diklat.isChecked) {
                uang.append("\n\t\tUang Diklat: Rp. 950.000")
                totalSPP += 950000
            }

            uang.append("\nTotal uang kuliah Rp. " + totalSPP)

            // Mengambil nilai RadioGroup
            val selectedBeasiswa:Int = beasiswa.checkedRadioButtonId
            rbBeasiswa = findViewById(selectedBeasiswa)

            outNilai.text = "Detil Nilai Mahasiswa" +
                    "\nNama Mahasiswa\t: $namaMhs" +
                    "\nNilai Harian\t: $nHarian" +
                    "\nNilai UTS\t: $nUts" +
                    "\nNilai UAS\t: $nUas" +
                    "\nJumlah SKS\t: $jumlahSks" +
                    "\nNilai Akhir\t: $akhir" +
                    "\nUang Pembayaran\t: " + uang.toString() +
                    "\nStatus Beasiswa\t: " + rbBeasiswa.text.toString()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}