package com.team.courseselector;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
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
public class ViewCommentTest extends TestCase {

    public static final String TAG_AVIA="Aviation";
    public static final String TAG_AVIA474="AVIA474";


    @Rule
    public ActivityTestRule<GroupActivity> mActivityRule = new ActivityTestRule<>(
            GroupActivity.class);
    @Test
    public void testAddCommpetTO651() {

        onView(withId(R.id.rv_group)).perform(RecyclerViewActions.scrollTo(hasDescendant(withText("VPA"))));
        onView(withText("VPA")).perform(click());
        //onView(withId(R.id.rv_group)).check(matches(hasDescendant(withText("VPA"))));
        onView(withId(R.id.menu_search)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText(TAG_AVIA));
        //onView(isAssignableFrom(EditText.class)).perform(typeText("test"), pressKey(66));
        onView(withId(R.id.rv_subject)).check(matches(hasDescendant(withText(TAG_AVIA))));
        onView(withText(TAG_AVIA)).perform(click());
        onView(withId(R.id.menu_search)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText(TAG_AVIA474));
        //onView(isAssignableFrom(EditText.class)).perform(typeText("test"), pressKey(66));
        onView(withId(R.id.rv_courses)).check(matches(hasDescendant(withText(TAG_AVIA474))));

        onView(withText(TAG_AVIA474)).perform(click());
        onView(withId(R.id.tv_difficulty)).check(matches(isDisplayed()));
    }
}
