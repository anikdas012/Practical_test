package tk.anikdas.anikdas012.mobileapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tk.anikdas.anikdas012.mobileapplication.databinding.FragmentResetPasswordBinding

/**
 * Created by "Anik Das" on 30-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

class ResetPasswordFragment : Fragment() {

    private lateinit var binding: FragmentResetPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentResetPasswordBinding.inflate(layoutInflater)
        return binding.root
    }
}