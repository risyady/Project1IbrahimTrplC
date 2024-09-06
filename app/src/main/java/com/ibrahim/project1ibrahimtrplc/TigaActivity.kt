package com.ibrahim.project1ibrahimtrplc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class TigaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val selectPiece = arrayOf<String>("  Meter", "  Gram", "  Piece(s)")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiga)

        /**
         * intent:
         *  explisit (dibuat oleh programmer)
         *  implisit (kamera, browser) -> udah ada dalam android
         */

        val product = findViewById<EditText>(R.id.editProduct)
        val price = findViewById<EditText>(R.id.editPrice)
        val piece = findViewById<Spinner>(R.id.spinPieces)
        val total = findViewById<EditText>(R.id.editTotal)
        val trans = findViewById<Button>(R.id.btnTransaction)

        piece.onItemSelectedListener=this

        val SpinPiece:ArrayAdapter<*> = ArrayAdapter<Any?>(this@TigaActivity, R.layout.spinner_style, selectPiece)
        SpinPiece.setDropDownViewResource(R.layout.spinner_style)
        piece.adapter = SpinPiece

        trans.setOnClickListener {
            val priceProduct = price.text.toString().toInt()
            val totalProduct = total.text.toString().toInt()
            val totalPrice = priceProduct * totalProduct
            val intent = Intent(this@TigaActivity, EmpatActivity::class.java)
            val bundle = Bundle()
            bundle.putString("name", product.text.toString())
            bundle.putString("price", price.text.toString())
            bundle.putString("total", totalPrice.toString())
            bundle.putString("piece", piece.selectedItem.toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}