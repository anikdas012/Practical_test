package tk.anikdas.anikdas012.mobileapplication.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import tk.anikdas.anikdas012.mobileapplication.MainActivity
import tk.anikdas.anikdas012.mobileapplication.R
import tk.anikdas.anikdas012.mobileapplication.databinding.FragmentResetPasswordBinding
import tk.anikdas.anikdas012.mobileapplication.viewmodel.ResetPasswordViewModel
import tk.anikdas.anikdas012.mobileapplication.viewmodel.ViewModelProvidersFactory
import javax.inject.Inject

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

class ResetPasswordFragment : Fragment() {

    private lateinit var binding: FragmentResetPasswordBinding
    private lateinit var username: String
    private lateinit var viewModel: ResetPasswordViewModel
    @Inject
    lateinit var providersFactory: ViewModelProvidersFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentResetPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username = arguments?.getString("username")!!
        binding.loginTextview.setOnClickListener {
            Navigation.findNavController(this.activity as Activity, R.id.nav_host_fragment)
                .navigate(R.id.loginFragment)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).fragmentComponent.inject(this)
    }
}