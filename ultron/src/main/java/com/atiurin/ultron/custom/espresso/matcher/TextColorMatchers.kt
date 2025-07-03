package com.atiurin.ultron.custom.espresso.matcher

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.test.espresso.matcher.BoundedMatcher
import com.atiurin.ultron.utils.getColorHex
import org.hamcrest.Description
import org.hamcrest.Matcher

internal fun hasColor(colorResId: Int, textViewColorPropertyName: String = "", viewColorSelector: TextView.() -> Int): Matcher<View> {
  return object : BoundedMatcher<View, TextView>(TextView::class.java) {
    var context: Context? = null
    var expectedColor: Int = 0
    var actualColor: Int = 0

    override fun describeTo(description: Description) {
      description.appendText("textView $textViewColorPropertyName with color ")
      context?.let {
        expectedColor = if (Build.VERSION.SDK_INT <= 22) {
          it.resources.getColor(colorResId)
        } else {
          it.getColor(colorResId)
        }
        description.appendText(getColorHex(expectedColor))
      } ?: run {
        description.appendText("resource ID ").appendValue(colorResId)
      }
    }

    override fun matchesSafely(textView: TextView): Boolean {
      context = textView.context
      actualColor = viewColorSelector.invoke(textView)
      expectedColor = if (Build.VERSION.SDK_INT <= 22) {
        textView.context.resources.getColor(colorResId)
      } else {
        textView.context.getColor(colorResId)
      }
      return actualColor == expectedColor
    }
  }
}

fun textViewHasCurrentTextColor(colorResId: Int) = hasColor(colorResId, "currentTextColor") { this.currentTextColor }
fun textViewHasHighlightColor(colorResId: Int) = hasColor(colorResId, "highlightColor") { this.highlightColor }
fun textViewHasShadowColor(colorResId: Int) = hasColor(colorResId, "shadowColor") { this.shadowColor }
fun textViewHasCurrentHintTextColor(colorResId: Int) = hasColor(colorResId, "currentHintTextColor") { this.currentHintTextColor }
