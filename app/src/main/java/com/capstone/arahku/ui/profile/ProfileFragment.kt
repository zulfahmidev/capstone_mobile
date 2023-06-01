package com.capstone.arahku.ui.profile

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.capstone.arahku.R
import com.capstone.arahku.databinding.FragmentProfileBinding
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.viewmodel.ProfileViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory
import java.nio.file.attribute.AclEntry

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

        binding?.btnProfileLogout?.setOnClickListener {
            AlertDialog.Builder(requireActivity()).apply {
                setIcon(R.drawable.ic_exit)
                setTitle("Logout")
                setMessage("Apakah kamu yakin ingin Logout dari akun ini?")
                setPositiveButton("Ya"){_, _ ->
                    profileViewModel.logout()
                }
                setNegativeButton("Tidak", null)
                show()
            }
        }

    }
}