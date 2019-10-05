package com.example.ssn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_stocks_class.*

class StocksClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stocks_class)

        val list_of_products = listOf(
            ProductClass("Bread", "Today"),
            ProductClass("Banana", "Tomorrow"),
            ProductClass("Tomato", "07 October 2019"),
            ProductClass("Tomato", "07 October 2019")

        )

        ProductRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@StocksClass)
            adapter = ProductAdapter(list_of_products)
        }
    }
}