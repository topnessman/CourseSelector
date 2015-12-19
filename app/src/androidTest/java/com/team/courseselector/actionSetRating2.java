package com.team.courseselector;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SeekBar;

import org.hamcrest.Matcher;

/**
 * Created by tamier on 02/12/15.
 */
public class actionSetRating2 {

    public static ViewAction setRating() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(SeekBar.class);
            }

            @Override
            public String getDescription() {
                return "set progress";
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((SeekBar) view).setProgress(2);
            }
        };
    }
}
