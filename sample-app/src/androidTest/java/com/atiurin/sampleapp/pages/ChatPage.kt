package com.atiurin.sampleapp.pages

import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R

class ChatPage {

    val messageInputField: Matcher<View> by lazy { withId(R.id.message_input_text) }
    val messageSendButton: Matcher<View> by lazy { withId(R.id.send_button) }
    val toolbarTitle: Matcher<View> by lazy { withId(R.id.toolbar_title) }
    private val messagesList: Matcher<View> by lazy { withId(R.id.messages_list) }

    fun getMessageByText(text: String): ViewInteraction {
        return onView(allOf(
            withText(text),
            isDescendantOfA(messagesList)
        ))
    }
}
