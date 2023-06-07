package com.capstone.arahku.ui.home.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.arahku.databinding.ActivityDetailTestBinding
import com.capstone.arahku.model.source.MenuTest

class DetailTestActivity : AppCompatActivity() {

    private var binding: ActivityDetailTestBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTestBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Tes"

        val menuTest = intent.getSerializableExtra("menuTest") as? MenuTest
        menuTest?.let { showDetailTest(it) }

    }

    private fun showDetailTest(menuTest: MenuTest) {
        binding?.apply {
            tvDetailTest.text = menuTest.description
            ivDetailTest.setImageResource(menuTest.photo)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}