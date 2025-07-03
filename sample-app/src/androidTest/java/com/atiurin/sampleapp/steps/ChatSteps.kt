package com.atiurin.sampleapp.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.sampleapp.helper.tap
import com.atiurin.sampleapp.pages.ChatPage

class ChatSteps {

    private val chatPage = ChatPage()

    fun typeMessage(text: String): ChatSteps {
        onView(chatPage.messageInputField).perform(typeText(text))
        return this
    }

    fun clickSend(): ChatSteps {
        onView(chatPage.messageSendButton).tap()
        return this
    }

    fun isMessageDisplayed(text: String): ChatSteps {
        chatPage.getMessageByText(text).check(matches(isDisplayed()))
        return this
    }

    fun checkChatIsOpenWith(userName: String): ChatSteps {
        onView(chatPage.toolbarTitle).check(matches(withText(userName)))
        return this
    }
}
