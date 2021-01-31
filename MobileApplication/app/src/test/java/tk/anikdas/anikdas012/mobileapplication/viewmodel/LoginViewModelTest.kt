package tk.anikdas.anikdas012.mobileapplication.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.Flowable
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import tk.anikdas.anikdas012.mobileapplication.getOrAwaitValueTest
import tk.anikdas.anikdas012.mobileapplication.models.LogInDetails
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

    @Test
    fun `Login without password`(){
        val details = LogInDetails(
            email = "demo@demo.com",
            password = null
        )
        val respone = LogInDetails(
            username = "Not found",
            email = "Not found",
            password = null
        )
        Mockito.`when`(loginApi.login(details)).thenReturn(Flowable.just(respone))
        assertNotNull(viewModel.loginUser(details))
        val value = viewModel.loginUser(details).getOrAwaitValueTest()
        assertThat(value.username, CoreMatchers.`is`(respone.username))
    }

    @Test
    fun `Login with password`(){
        val details = LogInDetails(
            email = "demo@demo.com",
            password = "demo"
        )
        val respone = LogInDetails(
            username = "Demo",
            email = "demo@demo.com",
            password = null
        )
        Mockito.`when`(loginApi.login(details)).thenReturn(Flowable.just(respone))
        assertNotNull(viewModel.loginUser(details))
        val value = viewModel.loginUser(details).getOrAwaitValueTest()
        assertThat(value.username, CoreMatchers.`is`(respone.username))
        assertThat(value.email, CoreMatchers.`is`(respone.email))
    }
}