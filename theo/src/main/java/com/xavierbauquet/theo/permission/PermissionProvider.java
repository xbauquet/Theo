package com.xavierbauquet.theo.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionProvider{
    final private int REQUEST_CODE = 987;

    private Context context;
    private Activity activity;

    public PermissionProvider() {
    }

    public PermissionProvider(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void requestPermissions(String[] permissions) {
        List<String> permissionsToCheck = new ArrayList<>();

        // Get the list of requested permissions that are not permission granted
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsToCheck.add(permission);
            }
        }

        // Request the permissions
        if (!permissionsToCheck.isEmpty() && Build.VERSION.SDK_INT >= 23) {
            String[] permissionsToRequest = permissionsToCheck.toArray(new String[permissionsToCheck.size()]);
            activity.requestPermissions(permissionsToRequest, REQUEST_CODE);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

}
