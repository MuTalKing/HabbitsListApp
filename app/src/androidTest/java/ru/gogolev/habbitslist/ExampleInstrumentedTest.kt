package ru.gogolev.habbitslist

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("ru.gogolev.habbitslist", appContext.packageName)
    }

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testHabbitCreation(){
        onView(withId(R.id.create_btn)).perform(click())
        onView(withId(R.id.name_field)).perform(replaceText("Каждый день писать тесты"))
        onView(withId(R.id.description_field)).perform(replaceText("Каждый день писать тесты"))
        onView(withId(R.id.create_btn)).perform(click())
        onView(withId(R.id.title)).check(matches(withText("Каждый день писать тесты")))
        onView(withId(R.id.description)).check(matches(withText("Каждый день писать тесты")))
    }
}