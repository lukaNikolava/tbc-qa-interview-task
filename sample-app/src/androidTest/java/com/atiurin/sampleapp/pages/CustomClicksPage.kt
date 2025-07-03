package com.atiurin.sampleapp.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.atiurin.sampleapp.R
import org.hamcrest.Matcher

class CustomClicksPage {

    val buttonsOverlay: Matcher<View> by lazy { withId(R.id.imageView) }
    val cornerCircleIds = listOf(
        R.id.rB_top_left,
        R.id.rB_bottom_left,
        R.id.rB_bottom_right,
        R.id.rB_top_right
    )
}
