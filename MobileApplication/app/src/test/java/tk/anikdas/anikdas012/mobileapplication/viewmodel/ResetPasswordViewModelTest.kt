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
import tk.anikdas.anikdas012.mobileapplication.models.ResetPasswordDetails
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

    @Test
    fun `Reset password with incorrect password`() {
        val details = ResetPasswordDetails(
            email = "demo@demo.com",
            password = "demo",
            confirmPassword = "demo4",
            code = "542"
        )
        val response = ResetPasswordDetails(
            username = "Not updated",
            email = "demo@demo.com",
            password = null,
            confirmPassword = null,
            code = null
        )
        Mockito.`when`(resetPasswordApi.resetPassword(details)).thenReturn(Flowable.just(response))
        assertNotNull(viewModel.resetPass(details))
        val value = viewModel.resetPass(details).getOrAwaitValueTest()
        assertThat(value.username, CoreMatchers.`is`("Not updated"))
    }

    @Test
    fun `Reset password with correct password`() {
        val details = ResetPasswordDetails(
            email = "demo@demo.com",
            password = "demo",
            confirmPassword = "demo",
            code = "542"
        )
        val response = ResetPasswordDetails(
            username = "demo",
            email = "demo@demo.com",
            password = null,
            confirmPassword = null,
            code = null
        )
        Mockito.`when`(resetPasswordApi.resetPassword(details)).thenReturn(Flowable.just(response))
        assertNotNull(viewModel.resetPass(details))
        val value = viewModel.resetPass(details).getOrAwaitValueTest()
        assertThat(value.username, CoreMatchers.`is`("demo"))
        assertThat(value.email, CoreMatchers.`is`(response.email))
    }
}