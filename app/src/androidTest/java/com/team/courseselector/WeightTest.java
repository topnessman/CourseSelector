package com.team.courseselector;

import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.hamcrest.core.StringContains;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.Delayed;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by tamier on 02/12/15.
 */
@RunWith(AndroidJUnit4.class)
public class WeightTest extends TestCase {

    public static final String TAG_ECE606="ECE606";

    @Rule
    public ActivityTestRule<GroupActivity> mActivityRule = new ActivityTestRule<>(
            GroupActivity.class);
    @Test
    public void testOpen() {

        onView(withId(R.id.drawer)).perform(actionOpenDrawer.OpenDrawer());
        //onView(withId(R.id.me)).perform(click());
        onView(withId(R.id.drawer)).perform(click());
        onView(withText(("Calculate"))).perform(click());

        onView(withId(R.id.menu_add)).perform(click());
        onView(withId(R.id.editText)).perform(typeText(TAG_ECE606));
        onView(withId(R.id.seekBar2)).perform(actionSetRating2.setRating());
        onView(withId(R.id.seekBar3)).perform(actionSetRating3.setRating());
        onView(withId(R.id.seekBar4)).perform(actionSetRating7.setRating());
        onView(withId(R.id.seekBar5)).perform(actionSetRating10.setRating());
        closeSoftKeyboard();
        SystemClock.sleep(1000);
        onView(withId(R.id.menu_ok)).perform(click());
        onView(withText(TAG_ECE606)).check(matches(isDisplayed()));
        //onView(withId(R.id.menu_next)).perform(click());

    }


}
