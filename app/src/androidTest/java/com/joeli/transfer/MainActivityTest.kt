package com.joeli.transfer

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun initial() {
        onView(withId(R.id.amountField)).check(matches(withText("")))
        onView(withId(R.id.submitButton)).check(matches(not(isEnabled())))
        onView(withId(R.id.resultView)).check(matches(not(isDisplayed())))
    }

    @Test
    fun submitAndReset() {
        onView(withId(R.id.amountField))
                .perform(typeText("153"))
        onView(withId(R.id.submitButton))
                .check(matches(isEnabled()))
                .perform(click())
                .check(matches(not(isDisplayed())))
        onView(withId(R.id.resultView))
                .check(matches(isDisplayed()))

        Thread.sleep(1000)

        onView(withId(R.id.resetButton))
                .check(matches(isDisplayed()))
                .perform(click())
        onView(withId(R.id.resultView))
                .check(matches(not(isDisplayed())))
        onView(withId(R.id.submitButton))
                .check(matches(not(isEnabled())))
                .check(matches(isDisplayed()))
    }
}
