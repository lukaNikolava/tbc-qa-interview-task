package com.atiurin.sampleapp.tests

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.platform.app.InstrumentationRegistry
import com.atiurin.ultron.testlifecycle.rulesequence.RuleSequence
import com.atiurin.sampleapp.data.repositories.CURRENT_USER
import com.atiurin.sampleapp.managers.AccountManager
import com.atiurin.ultron.core.config.UltronConfig
import com.atiurin.ultron.listeners.TimeListener
import com.atiurin.ultron.testlifecycle.setupteardown.SetUpRule
import org.junit.After
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule

abstract class BaseTest {
    private val setupRule = SetUpRule().add {
        AccountManager(InstrumentationRegistry.getInstrumentation().targetContext).login(
            CURRENT_USER.login, CURRENT_USER.password
        )
    }

    @get:Rule
    open val ruleSequence = RuleSequence(setupRule)

    companion object {
        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            UltronConfig.UiAutomator.speedUp()
            UltronConfig.addGlobalListener(TimeListener())
        }

        @AfterClass
        @JvmStatic
        fun tearDownClass() {
            UltronConfig.removeGlobalListener(TimeListener::class.java)
        }
    }

    @After
    fun tearDown() {
        clearAppCache()

        try {
            pressBackUnconditionally()
        } catch (e: Exception) {
            // Already at main screen or no activity to go back from
        }
    }

    private fun clearAppCache() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val cacheDir = context.cacheDir
        if (cacheDir.exists()) {
            cacheDir.deleteRecursively()
        }
    }
}
