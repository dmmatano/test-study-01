package com.example.unittestsstudy

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val mainActivityRule = ActivityTestRule(MainActivity::class.java) //use ActivityScenario

    @Test
    fun whenActivityIsLaunched_shouldDisplayInitialState(){
        onView(withId(R.id.number_textView)).check(matches(isDisplayed()))
        onView(withId(R.id.even_textView)).check(matches(isDisplayed()))
        onView(withId(R.id.increase_button)).check(matches(isDisplayed()))
        onView(withId(R.id.decrease_button)).check(matches(not(isDisplayed())))
    }

}
