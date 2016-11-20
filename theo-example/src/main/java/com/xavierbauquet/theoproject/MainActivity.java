package com.xavierbauquet.theoproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.xavierbauquet.theo.annotations.calendar.ReadCalendar;
import com.xavierbauquet.theo.annotations.calendar.WriteCalendar;
import com.xavierbauquet.theo.annotations.camera.Camera;
import com.xavierbauquet.theo.annotations.contacts.GetAccounts;
import com.xavierbauquet.theo.annotations.contacts.ReadContacts;
import com.xavierbauquet.theo.annotations.contacts.WriteContacts;
import com.xavierbauquet.theo.annotations.location.AccessCoarseLocation;
import com.xavierbauquet.theo.annotations.location.AccessFineLocation;
import com.xavierbauquet.theo.annotations.microphone.RecordAudio;
import com.xavierbauquet.theo.annotations.phone.AddVoicemail;
import com.xavierbauquet.theo.annotations.phone.CallPhone;
import com.xavierbauquet.theo.annotations.phone.ProcessOutgoingCalls;
import com.xavierbauquet.theo.annotations.phone.ReadCallLog;
import com.xavierbauquet.theo.annotations.phone.ReadPhoneState;
import com.xavierbauquet.theo.annotations.phone.UseSip;
import com.xavierbauquet.theo.annotations.phone.WriteCallLog;
import com.xavierbauquet.theo.annotations.sensors.BodySensors;
import com.xavierbauquet.theo.annotations.sms.ReadSms;
import com.xavierbauquet.theo.annotations.sms.ReceiveMms;
import com.xavierbauquet.theo.annotations.sms.ReceiveSms;
import com.xavierbauquet.theo.annotations.sms.ReceiveWapPush;
import com.xavierbauquet.theo.annotations.sms.SendSms;
import com.xavierbauquet.theo.annotations.storage.ReadExternalStorage;
import com.xavierbauquet.theo.annotations.storage.WriteExternalStorage;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private static final String THEO_TAG = "THEO";
    private final String[] permissions = {"Read Calendar", "Write Calendar", "Camera"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.row, permissions);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Read Calendar
                        receiveMmsMethod();
                        break;
                    case 1:
                        // Write Calendar
                        writeCalendarMethod();
                        break;
                    case 2:
                        // Camera
                        cameraMethod();
                        break;
                }
            }
        });
    }

    @ReadCalendar
    public void readCalendarMethod() {
        Log.i(THEO_TAG, "ReadCalendarMethod called");
    }

    @WriteCalendar
    public void writeCalendarMethod() {
        Log.i(THEO_TAG, "WriteCalendarMethod called");
    }

    @Camera
    public void cameraMethod() {
        Log.i(THEO_TAG, "CameraMethod called");
    }

    @GetAccounts
    public void getAccountsMethod() {
        Log.i(THEO_TAG, "GetAccountsMethod called");
    }

    @ReadContacts
    public void readContacts() {
        Log.i(THEO_TAG, "ReadContacts called");
    }

    @WriteContacts
    public void writeContacts() {
        Log.i(THEO_TAG, "WriteContacts called");
    }

    @AccessCoarseLocation
    public void coarseLocationMethod() {
        Log.i(THEO_TAG, "CoarseLocationMethod called");
    }

    @AccessFineLocation
    public void fineLocationMethod() {
        Log.i(THEO_TAG, "CoarseLocationMethod called");
    }

    @RecordAudio
    public void microphoneMethod() {
        Log.i(THEO_TAG, "CoarseLocationMethod called");
    }

    @AddVoicemail
    public void addVoiceMailMethod() {
        Log.i(THEO_TAG, "AddVoiceMailMethod called");
    }

    @CallPhone
    public void callPhoneMethod() {
        Log.i(THEO_TAG, "AddVoiceMailMethod called");
    }

    @ProcessOutgoingCalls
    public void processOutgoingCallsMethod() {
        Log.i(THEO_TAG, "ProcessOutgoingCallsMethod called");
    }

    @ReadCallLog
    public void readCallLogMethod() {
        Log.i(THEO_TAG, "ReadCallLogMethod called");
    }

    @ReadPhoneState
    public void readPhoneStateMethod() {
        Log.i(THEO_TAG, "ReadPhoneStateMethod called");
    }

    @UseSip
    public void useSipMethod() {
        Log.i(THEO_TAG, "UseSipMethod called");
    }

    @WriteCallLog
    public void writeCallLogMethod() {
        Log.i(THEO_TAG, "WriteCallLogMethod called");
    }

    @BodySensors
    public void bodySensorsMethod() {
        Log.i(THEO_TAG, "BodySensorsMethod called");
    }

    @ReadSms
    public void readSmsMethod() {
        Log.i(THEO_TAG, "ReadSmsMethod called");
    }

    @ReceiveMms
    public void receiveMmsMethod() {
        Log.i(THEO_TAG, "ReceiveMmsMethod called");
    }

    @ReceiveSms
    public void receiveSmsMethod() {
        Log.i(THEO_TAG, "ReceiveSmsMethod called");
    }

    @ReceiveWapPush
    public void receiveWapPushMethod() {
        Log.i(THEO_TAG, "ReceiveWapPushMethod called");
    }

    @SendSms
    public void sendSmsMethod() {
        Log.i(THEO_TAG, "SendSmsMethod called");
    }

    @ReadExternalStorage
    public void readExternalStorageMethod() {
        Log.i(THEO_TAG, "ReadExternalStorageMethod called");
    }

    @WriteExternalStorage
    public void writeExternalStorageMethod() {
        Log.i(THEO_TAG, "WriteExternalStorageMethod called");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Do something
    }
}
