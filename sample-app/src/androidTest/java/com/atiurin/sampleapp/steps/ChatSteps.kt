package com.atiurin.sampleapp.steps

import com.atiurin.sampleapp.helper.tap
import com.atiurin.sampleapp.helper.typeText
import com.atiurin.sampleapp.helper.assertIsViewDisplayed
import com.atiurin.sampleapp.helper.assertTextEquals
import com.atiurin.sampleapp.pages.ChatPage

class ChatSteps {

    private val chatPage = ChatPage()

    fun typeMessage(text: String): ChatSteps {
        chatPage.messageInputField.typeText(text)
        return this
    }

    fun clickSend(): ChatSteps {
        chatPage.messageSendButton.tap()
        return this
    }

    fun isMessageDisplayed(text: String): ChatSteps {
        chatPage.getMessageByText(text).assertIsViewDisplayed()
        return this
    }

    fun checkChatIsOpenWith(userName: String): ChatSteps {
        chatPage.toolbarTitle.assertTextEquals(userName)
        return this
    }
}
