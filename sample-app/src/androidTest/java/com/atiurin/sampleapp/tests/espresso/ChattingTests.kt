package com.atiurin.sampleapp.tests.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.constants.TestConstants
import com.atiurin.sampleapp.helper.isTextOnScreen
import com.atiurin.sampleapp.helper.isViewDisplayed
import com.atiurin.sampleapp.helper.typeText
import com.atiurin.sampleapp.pages.UIElementPage
import com.atiurin.sampleapp.steps.ChatSteps
import com.atiurin.sampleapp.steps.UIElementSteps
import com.atiurin.sampleapp.tests.BaseTest
import com.atiurin.ultron.extensions.tap
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChattingTests: BaseTest() {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    private val uiSteps = UIElementSteps()
    private val chatSteps = ChatSteps()

    @Test
    fun textWithMyFriend() {
        with(UIElementPage) {
            isTextOnScreen(TestConstants.DASHBOARD_TITLE)
            nameChandler.isViewDisplayed()
            nameChandler.tap()
            textInput.typeText(TestConstants.MSG_TO_RACHEL)
            messageInputText.isViewDisplayed()
        }
    }

    @Test
    fun textWithRachelGreen() {
        uiSteps.apply {
            checkTextIsDisplayed(TestConstants.DASHBOARD_TITLE)
            openChatByUserName(TestConstants.USER_NAME)
        }

        chatSteps.apply {
            checkChatIsOpenWith(TestConstants.USER_NAME)
            typeMessage(TestConstants.MSG_TO_RACHEL)
            clickSend()
            isMessageDisplayed(TestConstants.MSG_TO_RACHEL)
        }
    }
}
