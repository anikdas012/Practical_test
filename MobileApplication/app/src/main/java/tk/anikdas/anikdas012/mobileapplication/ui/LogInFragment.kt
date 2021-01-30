package tk.anikdas.anikdas012.mobileapplication.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import tk.anikdas.anikdas012.mobileapplication.MainActivity
import tk.anikdas.anikdas012.mobileapplication.R
import tk.anikdas.anikdas012.mobileapplication.databinding.FragmentLoginBinding
import tk.anikdas.anikdas012.mobileapplication.models.LogInDetails
import tk.anikdas.anikdas012.mobileapplication.models.UserDetails
import tk.anikdas.anikdas012.mobileapplication.viewmodel.CreateViewModel
import tk.anikdas.anikdas012.mobileapplication.viewmodel.LoginViewModel
import tk.anikdas.anikdas012.mobileapplication.viewmodel.ViewModelProvidersFactory
import javax.inject.Inject

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    @Inject
    lateinit var providersFactory: ViewModelProvidersFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, providersFactory).get(LoginViewModel::class.java)
        binding.forgotPasswordTextview.setOnClickListener {
            Navigation.findNavController(this.activity as Activity, R.id.nav_host_fragment)
                .navigate(R.id.forgotPasswordFragment)
        }
        binding.signinTextview.setOnClickListener {
            Navigation.findNavController(this.activity as Activity, R.id.nav_host_fragment)
                .navigate(R.id.createFragment)
        }
        binding.loginTextview.setOnClickListener {
            logInUser()
        }
    }

    private fun logInUser() {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).fragmentComponent.inject(this)
    }
}