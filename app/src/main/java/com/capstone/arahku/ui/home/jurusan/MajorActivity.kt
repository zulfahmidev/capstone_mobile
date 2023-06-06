package com.capstone.arahku.ui.home.jurusan

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.arahku.adapter.MajorAdapter
import com.capstone.arahku.databinding.ActivityMajorBinding
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.model.response.MajorData
import com.capstone.arahku.utils.Helper
import com.capstone.arahku.viewmodel.MajorViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory

class MajorActivity : AppCompatActivity() {

    private var _binding: ActivityMajorBinding? = null
    private val binding get() = _binding

    private var listMajor = ArrayList<MajorData>()
    private val helper = Helper()

    private lateinit var majorViewModel: MajorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMajorBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Jurusan"

        viewModelSetup()

    }

    private fun viewModelSetup(){
        val pref = UserPreference.getInstance(dataStore)
        majorViewModel = ViewModelProvider(this, ViewModelFactory(pref))[MajorViewModel::class.java]

        majorViewModel.listMajor.observe(this) {
            setMajorData(listMajor)
        }

        majorViewModel.isLoading.observe(this) {
            helper.showLoading(it, binding!!.progressBar)
        }

        majorViewModel.status.observe(this) { status ->
            status?.let {
                Toast.makeText(this, status.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        majorViewModel.getMajor(MajorData())
    }

    private fun setMajorData(listMajor: List<MajorData>) {
        val majors = ArrayList<MajorData>()
        for (user in listMajor) {
            majors.clear()
            majors.addAll(listMajor)
        }
        val adapter = MajorAdapter(majors)
        binding?.apply {
            rvMajor.adapter = adapter
            rvMajor.layoutManager = LinearLayoutManager(this@MajorActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}