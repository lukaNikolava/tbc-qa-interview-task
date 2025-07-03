package com.atiurin.sampleapp.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.atiurin.sampleapp.helper.tap
import com.atiurin.sampleapp.pages.UIElementPage
import com.atiurin.ultron.extensions.isDisplayed

class UIElementSteps {

    fun checkTextIsDisplayed(text: String): UIElementSteps {
        onView(withText(text)).isDisplayed()
        return this
    }

    fun openChatByUserName(username: String): UIElementSteps {
        onView(withText(username)).tap()
        return this
    }

    fun openMainMenu(): UIElementSteps {
        onView(UIElementPage.mainMenuBtn).check(matches(isDisplayed())).tap()
        return this
    }

    fun navCustomClickPage(): UIElementSteps {
        onView(UIElementPage.customClicksNavBtn).tap()
        return this
    }
}
