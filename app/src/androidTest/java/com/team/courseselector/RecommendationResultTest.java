package com.team.courseselector;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
public class RecommendationResultTest extends TestCase {

    public static final String TAG_SYDE683="SYDE683";
    public static final String TAG_AVIA474="AVIA474";


    @Rule
    public ActivityTestRule<GroupActivity> mActivityRule = new ActivityTestRule<>(
            GroupActivity.class);
    @Test
    public void testOpen() {

        onView(withId(R.id.drawer)).perform(actionOpenDrawer.OpenDrawer());
        //onView(withId(R.id.me)).perform(click());
        //onView(withId(R.id.drawer)).perform(click());
        onView(withId(R.id.drawer)).perform(click());
        onView(withText(("Calculate"))).perform(click());
        //onView(with)R.id.drawer
        //onView(withId(R.id.menu_calculate)).perform(click());
        //SystemClock.sleep(10000);
        //

        onView(withId(R.id.menu_add)).perform(click());
        onView(withId(R.id.editText)).perform(typeText(TAG_AVIA474));
        onView(withId(R.id.seekBar2)).perform(actionSetRating2.setRating());
        onView(withId(R.id.seekBar3)).perform(actionSetRating3.setRating());
        onView(withId(R.id.seekBar4)).perform(actionSetRating7.setRating());
        onView(withId(R.id.seekBar5)).perform(actionSetRating10.setRating());
        closeSoftKeyboard();
        SystemClock.sleep(1000);
        onView(withId(R.id.menu_ok)).perform(click());
        onView(withText(TAG_AVIA474)).check(matches(isDisplayed()));
        onView(withId(R.id.menu_add)).perform(click());
        onView(withId(R.id.editText)).perform(typeText(TAG_SYDE683));
        onView(withId(R.id.seekBar5)).perform(actionSetRating2.setRating());
        onView(withId(R.id.seekBar4)).perform(actionSetRating3.setRating());
        onView(withId(R.id.seekBar3)).perform(actionSetRating7.setRating());
        onView(withId(R.id.seekBar2)).perform(actionSetRating10.setRating());
        closeSoftKeyboard();
        SystemClock.sleep(1000);
        onView(withId(R.id.menu_ok)).perform(click());
        onView(withText(TAG_SYDE683)).check(matches(isDisplayed()));
        onView(withId(R.id.menu_next)).perform(click());
        onView(withId(R.id.seekBar6)).perform(actionSetRating10.setRating());
        onView(withId(R.id.seekBar7)).perform(actionSetRating25.setRating());
        onView(withId(R.id.seekBar8)).perform(actionSetRating30.setRating());
        SystemClock.sleep(1000);
        onView(withId(R.id.menu_next)).perform(click());
        onView(withText("Results")).check(matches(isDisplayed()));
        SystemClock.sleep(1000);
        //onView(withId(R.id.menu_next)).perform(click());

    }


}
