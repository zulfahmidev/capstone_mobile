package com.capstone.arahku.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.capstone.arahku.R
import com.capstone.arahku.databinding.FragmentProfileBinding
import com.capstone.arahku.model.response.AccountData
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.ui.LandingPageActivity
import com.capstone.arahku.viewmodel.ProfileViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelSetup()
    }

    private fun viewModelSetup(){
        val pref = UserPreference.getInstance(requireContext().dataStore)
        profileViewModel = ViewModelProvider(this, ViewModelFactory(pref))[ProfileViewModel::class.java]

        profileViewModel.apply {
            token().observe(viewLifecycleOwner){token ->

                val bearer = getString(R.string.Bearer)
                getAccount(bearer + token)
            }

            account.observe(viewLifecycleOwner){account ->
                setData(account)
                val id = account?.id
                val bundle = Bundle()
                if (id != null) {
                    bundle.putInt("id_key", id)
                }
            }
        }

        binding?.btnProfileLogout?.setOnClickListener {
            AlertDialog.Builder(requireActivity()).apply {
                setIcon(R.drawable.ic_exit)
                setTitle("Logout")
                setMessage("Apakah kamu yakin ingin Logout dari akun ini?")
                setPositiveButton("Ya"){_, _ ->
                    profileViewModel.logout()
                    startActivity(Intent(requireContext(), LandingPageActivity::class.java))
                    requireActivity().onBackPressed()
                }
                setNegativeButton("Tidak", null)
                show()
            }
        }
    }

    private fun setData(accountData: AccountData?){
        binding?.apply {
            Glide.with(profileImg.context)
                .load(accountData?.picture)
                .placeholder(R.drawable.img_profile)
                .into(profileImg)

            profileName.text = accountData?.name
            profileEmail.text = accountData?.email
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}