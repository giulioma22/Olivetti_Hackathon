package com.example.ssn

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StocksButton.setOnClickListener {
            d("Stocks","StockButton pressed!")
            startActivity(Intent(this, StocksClass::class.java))
        }
        StatisicsButton.setOnClickListener {
            d("Statistics","StatisticsButton pressed!")
            startActivity(Intent(this, StatsClass::class.java))
        }


    }

}
