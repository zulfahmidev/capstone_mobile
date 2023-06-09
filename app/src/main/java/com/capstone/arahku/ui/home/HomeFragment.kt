package com.capstone.arahku.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.capstone.arahku.R
import com.capstone.arahku.databinding.FragmentHomeBinding
import com.capstone.arahku.model.response.AccountData
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.ui.home.friend.ClosestFriendActivity
import com.capstone.arahku.ui.home.major.MajorActivity
import com.capstone.arahku.ui.home.test.TestActivity
import com.capstone.arahku.viewmodel.ProfileViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel : ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMenuAction()
        viewModelSetup()
    }

    private fun setupMenuAction() {
        binding?.apply {
            ibMenu1.setOnClickListener {
                requireActivity().run {
                    startActivity(Intent(this, TestActivity::class.java))
                }
            }
            ibMenu2.setOnClickListener {
                requireActivity().run {
                    startActivity(Intent(this, MajorActivity::class.java))
                }
            }
            ibMenu3.setOnClickListener {
                requireActivity().run {
                    startActivity(Intent(this, ClosestFriendActivity::class.java))
                }
            }
            ibMenu4.setOnClickListener {
                Toast.makeText(context, "Fitur ini belum tersedia", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun viewModelSetup(){
        val pref = UserPreference.getInstance(requireContext().dataStore)
        viewModel = ViewModelProvider(this, ViewModelFactory(pref))[ProfileViewModel::class.java]

        viewModel.apply {
            token().observe(viewLifecycleOwner){token ->
                val bearer = getString(R.string.Bearer)
                getAccount(bearer + token)
            }

            account.observe(viewLifecycleOwner){accountData ->
                setData(accountData)
            }
        }

    }

    private fun setData(accountData: AccountData?){
        binding?.apply {
            Glide.with(homeProfileImg.context)
                .load(accountData?.picture)
                .placeholder(R.drawable.img_profile)
                .into(homeProfileImg)
            homeUsername.text = accountData?.name
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}