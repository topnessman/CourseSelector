package com.team.courseselector;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withTagValue;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static android.support.test.espresso.action.ViewActions.click;
/**
 * Created by tamier on 02/12/15.
 */
@RunWith(AndroidJUnit4.class)
public class PostCommentTest extends TestCase {

    public static final String TAG_ECE="Electrical and Computer Engineering";
    public static final String TAG_ECE651="ECE651";
    public static final String COMMENT="Very good course!";

    @Rule
    public ActivityTestRule<GroupActivity> mActivityRule = new ActivityTestRule<>(
            GroupActivity.class);
    @Test
    public void testAddCommpetTO651() {

        onView(withId(R.id.rv_group)).perform(RecyclerViewActions.scrollTo(hasDescendant(withText("ENG"))));
        onView(withText("ENG")).perform(click());
        //onView(withId(R.id.rv_group)).check(matches(hasDescendant(withText("VPA"))));
        onView(withId(R.id.menu_search)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText(TAG_ECE));
        //onView(isAssignableFrom(EditText.class)).perform(typeText("test"), pressKey(66));
        onView(withId(R.id.rv_subject)).check(matches(hasDescendant(withText(TAG_ECE))));
        onView(withText(TAG_ECE)).perform(click());
        onView(withId(R.id.menu_search)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText(TAG_ECE651));
        //onView(isAssignableFrom(EditText.class)).perform(typeText("test"), pressKey(66));
        onView(withId(R.id.rv_courses)).check(matches(hasDescendant(withText(TAG_ECE651))));

        onView(withText(TAG_ECE651)).perform(click());
        onView(withId(R.id.btn_comment)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_comment)).perform(click());
        //onView(withText("COMMENT")).perform(click());
        onView(withId(R.id.rb_difficulty)).perform(actionSetRatingBar.setRating());
        onView(withId(R.id.rb_exam)).perform(actionSetRatingBar.setRating());
        onView(withId(R.id.rb_teacher)).perform(actionSetRatingBar.setRating());
        onView(withId(R.id.rb_usability)).perform(actionSetRatingBar.setRating());
        onView(withId(R.id.et_comment)).perform(typeText(COMMENT));
        ViewActions.closeSoftKeyboard();
        onView(withId(R.id.menu_submit)).perform(click());

    }
}
