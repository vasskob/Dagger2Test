package com.task.vasskob.testdaggersharedpref;

import android.os.SystemClock;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.task.vasskob.testdaggersharedpref.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.task.vasskob.testdaggersharedpref.Constants.DELAY_MS;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;


@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {

    private static final String TEST_STRING = "string for testing";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testOnSaveClick() {
        onSaveClick();
    }

    @Test
    public void testOnLoadClick() {
        onSaveClick();
        onView(withId(R.id.btn_load)).perform(click());
        onView(withId(R.id.pb_loading)).check(matches(isDisplayed()));
        SystemClock.sleep(2 * DELAY_MS);
        onView(withId(R.id.pb_loading)).check(matches(not(isDisplayed())));
        onView(withId(R.id.tv_title)).check(matches(withText(TEST_STRING)));
        onView(withText(R.string.load_success))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow()
                        .getDecorView()))))
                .check(matches(isDisplayed()));
    }

    private void onSaveClick() {
        onView(withId(R.id.edit_text)).perform(typeText(TEST_STRING));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.pb_loading)).check(matches(isDisplayed()));
        SystemClock.sleep(DELAY_MS);
        onView(withId(R.id.pb_loading)).check(matches(not(isDisplayed())));
        onView(withText(R.string.save_success))
                .inRoot(withDecorView(not(is(mActivityRule.getActivity().getWindow()
                        .getDecorView()))))
                .check(matches(isDisplayed()));
    }
}
