package com.ibrahim.project1ibrahimtrplc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TigaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiga)

        /**
         * intent:
         *  explisit (dibuat oleh programmer)
         *  implisit (kamera, browser) -> udah ada dalam android
         */

        val intent = Intent(this@TigaActivity, EmpatActivity::class.java)
    }
}