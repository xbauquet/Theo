package com.xavierbauquet.theo.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.xavierbauquet.theo.TheoListener;

import java.util.ArrayList;
import java.util.List;

public class PermissionProvider implements ActivityCompat.OnRequestPermissionsResultCallback {
    final private int REQUEST_CODE = 987;

    private Context context;
    private Activity activity;
    private TheoListener listener;

    public PermissionProvider() {
    }

    public void requestPermissions(String[] permissions) {
        List<String> permissionsToCheck = new ArrayList<>();

        // Get the list of requested permissions that are not permission granted
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsToCheck.add(permission);
            }
        }

        // Resquest the permission
        if (!permissionsToCheck.isEmpty() && Build.VERSION.SDK_INT >= 23) {
            String[] permissionsToRequest = permissionsToCheck.toArray(new String[permissionsToCheck.size()]);
            activity.requestPermissions(permissionsToRequest, REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE: {
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        listener.onPermissionRequestRefused(permissions[i]);
                    }
                }
            }
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

    public TheoListener getListener() {
        return listener;
    }

    public void setListener(TheoListener listener) {
        this.listener = listener;
    }
}
