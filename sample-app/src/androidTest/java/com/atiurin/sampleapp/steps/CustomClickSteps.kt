package com.atiurin.sampleapp.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.sampleapp.pages.CustomClicksPage

class CustomClickSteps {

    private val customClickPage = CustomClicksPage()

    fun checkCustomClicksPageIsOpened(): CustomClickSteps {
        onView(customClickPage.buttonsOverlay).check(matches(isDisplayed()))
        return this
    }

    fun markAllCornerCircles(): CustomClickSteps {
        customClickPage.cornerCircleIds.forEach { id ->
            onView(withId(id)).perform(click())
        }
        return this
    }

    fun validateAllCornerCirclesAreMarked(): CustomClickSteps {
        customClickPage.cornerCircleIds.forEach { id ->
            onView(withId(id)).check(matches(isChecked()))
        }
        return this
    }
}
