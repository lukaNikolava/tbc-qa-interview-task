package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import com.atiurin.sampleapp.R
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.instanceOf

object UIElementPage {

    val mainMenuBtn: Matcher<View> by lazy { withClassName(CoreMatchers.containsString("ImageButton")) }
    val customClicksNavBtn: Matcher<View> by lazy { withId(R.id.custom_clicks_nav_item) }
    val nameChandler: Matcher<View> by lazy { Matchers.allOf(withId(R.id.tv_name), withText("Chandler Bing")) }
    val messageInputText: Matcher<View> by lazy { Matchers.allOf(withId(R.id.message_input_text), withText("Enter text")) }
    val textInput: Matcher<View> by lazy { Matchers.allOf(withId(R.id.message_input_text)) }
}
