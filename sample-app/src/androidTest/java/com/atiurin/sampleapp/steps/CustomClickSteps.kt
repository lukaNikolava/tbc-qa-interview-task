package com.atiurin.sampleapp.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.sampleapp.helper.assertIsChecked
import com.atiurin.sampleapp.helper.assertIsViewDisplayed
import com.atiurin.sampleapp.helper.tap
import com.atiurin.sampleapp.pages.CustomClicksPage

class CustomClickSteps {

    private val customClickPage = CustomClicksPage()

    fun checkCustomClicksPageIsOpened(): CustomClickSteps {
        customClickPage.buttonsOverlay.assertIsViewDisplayed()
        return this
    }

    fun markAllCornerCircles(): CustomClickSteps {
        customClickPage.cornerCircleIds.forEach { id ->
            onView(withId(id)).tap()
        }
        return this
    }

    fun validateAllCornerCirclesAreMarked(): CustomClickSteps {
        customClickPage.cornerCircleIds.forEach { id ->
            onView(withId(id)).assertIsChecked()
        }
        return this
    }
}
