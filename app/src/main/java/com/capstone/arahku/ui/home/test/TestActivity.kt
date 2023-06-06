package com.capstone.arahku.ui.home.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.arahku.adapter.MenuTestAdapter
import com.capstone.arahku.databinding.ActivityTestBinding
import com.capstone.arahku.model.source.DummyDataSource
import com.capstone.arahku.model.source.MenuTest

class TestActivity : AppCompatActivity(), MenuTestAdapter.OnItemClickListener {

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Tes"

        initAdapter()

    }

    private fun initAdapter() {
        val adapter = MenuTestAdapter(DummyDataSource.menuTestList)
        adapter.setOnItemClickListener(this)
        binding.apply {
            rvMenuTest.adapter = adapter
            rvMenuTest.layoutManager = LinearLayoutManager(this@TestActivity)
        }

    }

    override fun onItemClick(menuTest: MenuTest) {
        val intent = Intent(this, DetailTestActivity::class.java)
        intent.putExtra("menuTest", menuTest)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}