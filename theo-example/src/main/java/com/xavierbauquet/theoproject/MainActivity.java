package com.xavierbauquet.theoproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.xavierbauquet.theo.camera.Camera;
import com.xavierbauquet.theo.location.AccessCoarseLocation;
import com.xavierbauquet.theo.location.AccessFineLocation;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback{

    public static final String THEO_TAG = "THEO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.coarse_location_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coarseLocationMethod();
            }
        });

        findViewById(R.id.fine_location_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fineLocationMethod();
            }
        });

        findViewById(R.id.camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraMethod();
            }
        });

        findViewById(R.id.fine_location_camera_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fineLocationAndCameraMethod();
            }
        });
    }

    @AccessCoarseLocation
    private void coarseLocationMethod() {
        Log.e(THEO_TAG, "CoarseLocationMethod called");
    }

    @AccessFineLocation
    private void fineLocationMethod() {
        Log.e(THEO_TAG, "CoarseLocationMethod called");
    }

    @Camera
    private void cameraMethod(){
        Log.e(THEO_TAG, "cameraMethod called");
    }

    @AccessFineLocation
    @Camera
    private void fineLocationAndCameraMethod(){
        Log.e(THEO_TAG, "fineLocationAndCameraMethod called");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Do something
    }
}
