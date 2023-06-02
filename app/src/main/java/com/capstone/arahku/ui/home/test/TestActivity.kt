package com.capstone.arahku.ui.home.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.arahku.adapter.MenuTestAdapter
import com.capstone.arahku.databinding.ActivityTestBinding
import com.capstone.arahku.model.source.DataSourceMenuTest

class TestActivity : AppCompatActivity() {

    private var binding: ActivityTestBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Tes"

        val adapter = MenuTestAdapter(DataSourceMenuTest.menuTestList)

        binding?.apply {
            rvMenuTest.adapter = adapter
            rvMenuTest.layoutManager = LinearLayoutManager(this@TestActivity)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}