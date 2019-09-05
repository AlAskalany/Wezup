package com.alaskalany.android.shared

import androidx.test.runner.AndroidJUnit4
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NetworkClientTest {

    private val weatherService: WeatherService = NetworkClient.instance

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun getInstance() {
        runBlocking {
            val response =
                weatherService.forecast("dafc50f09edd941ce1876d78a0a31b77", "42.3601", "-71.0589")
            println(response.body())
            assertTrue(response.isSuccessful)
            assertNotNull(response.body())
        }
    }
}