package com.atiurin.sampleapp.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.sampleapp.pages.UIElementPage

class UIElementSteps {

    fun checkTextIsDisplayed(text: String): UIElementSteps {
        onView(withText(text)).check(matches(isDisplayed()))
        return this
    }

    fun openChatByUserName(username: String): UIElementSteps {
        onView(withText(username)).perform(click())
        return this
    }

    fun openMainMenu(): UIElementSteps {
        onView(UIElementPage.mainManuBtn).perform(click())
        return this
    }

    fun navCustomClickPage(): UIElementSteps {
        onView(UIElementPage.customClicksNavBtn).perform(click())
        return this
    }
}
