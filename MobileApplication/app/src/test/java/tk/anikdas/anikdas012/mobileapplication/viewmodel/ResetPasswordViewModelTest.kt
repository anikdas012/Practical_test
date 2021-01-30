package tk.anikdas.anikdas012.mobileapplication.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tk.anikdas.anikdas012.mobileapplication.network.ResetPasswordApi

/**
 * Created by "Anik Das" on 31-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

@RunWith(JUnit4::class)
class ResetPasswordViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    lateinit var resetPasswordApi: ResetPasswordApi
    lateinit var viewModel: ResetPasswordViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = ResetPasswordViewModel(resetPasswordApi)
    }
}