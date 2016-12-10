package com.xavierbauquet.theoproject;

import android.Manifest;
import android.os.Build;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.xavierbauquet.theo.Theo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SnackBarTest {

    private UiDevice device;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void init() {
        device = UiDevice.getInstance(getInstrumentation());
    }

    @Test
    public void shouldShowSnackBar() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            Theo.checkPermission(activityRule.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
            String snackBarText = activityRule.getActivity().getResources().getString(R.string.snack_bar_text);
            UiObject snackBar = device.findObject(new UiSelector().text(snackBarText));
            assertTrue(snackBar.exists());
        }
    }

    @Test
    public void shouldAskForPermissionFromSnackBarButton() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            String snackBarButtonText = activityRule.getActivity().getResources().getString(R.string.snack_bar_button);
            UiObject snackBarButton = device.findObject(new UiSelector().text(snackBarButtonText));
            if (snackBarButton.exists()) {
                try {
                    snackBarButton.click();
                    testIfDialogIsDisplayed();
                    closePermissionDialog();
                } catch (UiObjectNotFoundException e) {
                }
            }
        }
    }

    private void testIfDialogIsDisplayed() {
        // test if the dialog opens
        UiObject allowPermissions = device.findObject(new UiSelector().text("Allow"));
        assertTrue(allowPermissions.exists());
    }

    private void closePermissionDialog() {
        UiObject denyPermissions = device.findObject(new UiSelector().text("Deny"));
        if (denyPermissions.exists()) {
            try {
                denyPermissions.click();
            } catch (UiObjectNotFoundException e) {
            }
        }
    }
}
