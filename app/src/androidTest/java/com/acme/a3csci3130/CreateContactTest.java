package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class CreateContactTest {
    public String testToFind;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void createTest() throws InterruptedException {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Andy"),closeSoftKeyboard());
        onView(withId(R.id.number)).perform(typeText("123456789"),closeSoftKeyboard());
        onView(withId(R.id.primary)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("vhkhiue"),closeSoftKeyboard());
        onView(withId(R.id.province)).perform(typeText("AB"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());

        onData(org.hamcrest.Matchers.anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        onView(withId(R.id.name)).check(matches(withText("Andy")));
        onView(withId(R.id.number)).check(matches(withText("123456789")));
        onView(withId(R.id.primary)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("vhkhiue")));
        onView(withId(R.id.province)).check(matches(withText("AB")));
    }





}
