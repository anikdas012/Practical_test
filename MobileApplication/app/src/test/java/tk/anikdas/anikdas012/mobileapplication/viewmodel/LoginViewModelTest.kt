package tk.anikdas.anikdas012.mobileapplication.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import tk.anikdas.anikdas012.mobileapplication.network.LoginApi

/**
 * Created by "Anik Das" on 31-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

@RunWith(JUnit4::class)
class LoginViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    lateinit var loginApi: LoginApi
    lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = LoginViewModel(loginApi)
    }
}