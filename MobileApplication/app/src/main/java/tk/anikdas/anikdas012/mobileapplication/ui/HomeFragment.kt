package tk.anikdas.anikdas012.mobileapplication.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import tk.anikdas.anikdas012.mobileapplication.R
import tk.anikdas.anikdas012.mobileapplication.databinding.FragmentHomeBinding

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginTextview.setOnClickListener {
            Navigation.findNavController(this.activity as Activity, R.id.nav_host_fragment)
                .navigate(R.id.loginFragment)
        }
        binding.getStartedTextview.setOnClickListener {
            Navigation.findNavController(this.activity as Activity, R.id.nav_host_fragment)
                .navigate(R.id.createFragment)
        }
    }
}