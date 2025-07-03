package com.atiurin.sampleapp.tests.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.constants.TestConstants
import com.atiurin.sampleapp.steps.CustomClickSteps
import com.atiurin.sampleapp.steps.UIElementSteps
import com.atiurin.sampleapp.tests.BaseTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class CustomClickTests: BaseTest() {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    private val uiSteps = UIElementSteps()
    private val customClicksPageSteps = CustomClickSteps()

    @Test
    fun testCustomClicksMarking() {
        uiSteps
            .checkTextIsDisplayed(TestConstants.DASHBOARD_TITLE)
            .openMainMenu()
            .navCustomClickPage()

        customClicksPageSteps
            .checkCustomClicksPageIsOpened()
            .markAllCornerCircles()
            .validateAllCornerCirclesAreMarked()
    }
}
