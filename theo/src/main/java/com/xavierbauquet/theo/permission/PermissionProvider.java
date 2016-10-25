package com.xavierbauquet.theo.permission;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionProvider {
    final private int REQUEST_CODE = 124;

    private Context context;
    private String[] permissions;

    public PermissionProvider(Context context) {
        this.context = context;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

    public void requestPermissions() {
        List<String> permissionsToCheck = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsToCheck.add(permission);
            }
        }
        if (!permissionsToCheck.isEmpty() && Build.VERSION.SDK_INT >= 23) {
            String[] permissions = permissionsToCheck.toArray(new String[permissionsToCheck.size()]);
            //activity.requestPermissions(permissions, REQUEST_CODE);
        }
    }

    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE: {
                Map<String, Integer> perms = new HashMap<>();
                // initialise
                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                // Fill with results
                for (int i = 0; i < permissions.length; i++) {
                    perms.put(permissions[i], grantResults[i]);
                }
                // Check for ACCESS_FINE_LOCATION
                return perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
            }
            default:
                return false;
        }
    }

    /*public boolean checkLocationPermissionWithSnackBar() {
        if (ActivityCompat.checkSelfPermission(context.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (activity != null) {
                snackbar.show();
            }
            return false;
        } else {
            return true;
        }
    }*/

    /*public boolean checkPermission() {
        if (ActivityCompat.checkSelfPermission(context.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }*/

}
