package com.xavierbauquet.theoproject;

import android.os.Build;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AnotationsTest {

    private UiDevice device;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void init() {
        device = UiDevice.getInstance(getInstrumentation());
    }

    @Test
    public void readCalendarTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().readCalendarMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void writeCalendarTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().writeCalendarMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void cameraTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().cameraMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void getAccountsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().getAccountsMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void readContactsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().readContacts();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void writeContactsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().writeContacts();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void coarseLocationTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().coarseLocationMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void fineLocationTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().fineLocationMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void recordAudioTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().microphoneMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void addVoicemailTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().addVoiceMailMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void callPhoneTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().callPhoneMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void processOutgoingCallsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().processOutgoingCallsMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void readCallLogTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().readCallLogMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void readPhoneStateTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().readPhoneStateMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void useSipTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().useSipMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void writeCallLogTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().writeCallLogMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void bodySensorsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().bodySensorsMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void readSmsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().readSmsMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void receiveMmsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().receiveMmsMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void receiveSmsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().receiveSmsMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void receiveWapPushTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().receiveWapPushMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void sendSmsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().sendSmsMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void readExternalStorageTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().readExternalStorageMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void writeExternalStorageTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().writeExternalStorageMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
        }
    }

    @Test
    public void permissionsTest() throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            // call method
            activityRule.getActivity().permissionsMethod();
            testIfDialogIsDisplayed();
            closePermissionDialog();
            testIfDialogIsDisplayed();
            closePermissionDialog();
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
