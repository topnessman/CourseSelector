package com.team.courseselector;

import android.app.Activity;
import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by tamier on 02/12/15.
 */
@RunWith(AndroidJUnit4.class)
public class AddToCompareListTest extends TestCase {

    public static final String TAG_UNIVERSITY="University";
    public static final String TAG_UNIVERSITY474="UNIV101";
    public static final String COMMENT="Very good course!";


    @Rule
    public ActivityTestRule<GroupActivity> mActivityRule = new ActivityTestRule<>(
            GroupActivity.class);
    @Test
    public void testAddCommpetTO651() {


        onView(withId(R.id.rv_group)).perform(RecyclerViewActions.scrollTo(hasDescendant(withText("VPA"))));
        onView(withText("VPA")).perform(click());
        //onView(withId(R.id.rv_group)).check(matches(hasDescendant(withText("VPA"))));
        onView(withId(R.id.menu_search)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText(TAG_UNIVERSITY));
        //onView(isAssignableFrom(EditText.class)).perform(typeText("test"), pressKey(66));
        onView(withId(R.id.rv_subject)).check(matches(hasDescendant(withText(TAG_UNIVERSITY))));
        onView(withText(TAG_UNIVERSITY)).perform(click());
        onView(withId(R.id.menu_search)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText(TAG_UNIVERSITY474));
        //onView(isAssignableFrom(EditText.class)).perform(typeText("test"), pressKey(66));
        onView(withId(R.id.rv_courses)).check(matches(hasDescendant(withText(TAG_UNIVERSITY474))));

        onView(withText(TAG_UNIVERSITY474)).perform(click());
        onView(withId(R.id.tv_difficulty)).check(matches(isDisplayed()));

        onView(withId(R.id.btn_add)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_add)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText(TAG_UNIVERSITY474)));
        onView(withId(R.id.seekBar2)).perform(actionSetRating2.setRating());
        onView(withId(R.id.seekBar3)).perform(actionSetRating3.setRating());
        onView(withId(R.id.seekBar4)).perform(actionSetRating7.setRating());
        onView(withId(R.id.seekBar5)).perform(actionSetRating10.setRating());
        onView(withId(R.id.menu_ok)).perform(click());
        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);
        onView(withId(R.id.drawer)).perform(actionOpenDrawer.OpenDrawer());
        onView(withId(R.id.drawer)).perform(click());
        onView(withText("Calculate")).perform(click());
        onView(withText(TAG_UNIVERSITY474)).check(matches(isDisplayed()));

    }

}
