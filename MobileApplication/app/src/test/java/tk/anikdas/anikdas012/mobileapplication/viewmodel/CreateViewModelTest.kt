package tk.anikdas.anikdas012.mobileapplication.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.reactivex.Flowable
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import tk.anikdas.anikdas012.mobileapplication.getOrAwaitValueTest
import tk.anikdas.anikdas012.mobileapplication.models.UserDetails
import tk.anikdas.anikdas012.mobileapplication.network.CreateApi

/**
 * Created by "Anik Das" on 31-Jan-2021
 * Developer email: "anikdas012@gmail.com"
 */

@RunWith(JUnit4::class)
class CreateViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var createApi: CreateApi
    lateinit var viewModel: CreateViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = CreateViewModel(createApi)
    }

    @Test
    fun `Create user with two different password`() {
        val userDetails = UserDetails(
            username = "name",
            email = "demo@demo.com",
            password = "demo",
            confirmPassword = "demo4"
        )
        val response = UserDetails(
            username = "name",
            email = "demo@demo.com",
            createdAt = -1,
            password = null,
            confirmPassword = null
        )
        `when`(createApi.createAccount(userDetails)).thenReturn(Flowable.just(response))
        assertNotNull(viewModel.createUser(userDetails))
        val value = viewModel.createUser(userDetails).getOrAwaitValueTest()
        assertThat(value.createdAt?.toInt(), `is`(-1))
    }

    @Test
    fun `Create user`() {
        val userDetails = UserDetails(
            username = "name",
            email = "demo@demo.com",
            password = "demo",
            confirmPassword = "demo"
        )
        val response = UserDetails(
            username = "name",
            email = "demo@demo.com",
            createdAt = System.currentTimeMillis(),
            password = null,
            confirmPassword = null
        )
        `when`(createApi.createAccount(userDetails)).thenReturn(Flowable.just(response))
        assertNotNull(viewModel.createUser(userDetails))
        val value = viewModel.createUser(userDetails).getOrAwaitValueTest()
        assertThat(value.email, `is`(userDetails.email))
    }
}