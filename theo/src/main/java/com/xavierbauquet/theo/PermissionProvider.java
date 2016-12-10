package com.xavierbauquet.theo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

class PermissionProvider {

    private Context context;
    private Activity activity;

    PermissionProvider(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    void requestPermissions(String[] permissions) {
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
            activity.requestPermissions(permissionsToRequest, Theo.REQUEST_CODE);
        }
    }

    boolean isPermissionGranted(String permission) {
        return isPermissionGranted(new String[]{permission});
    }

    boolean isPermissionGranted(String[] permissions){
        for(String permission : permissions){
            if(ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    Context getContext() {
        return context;
    }

    void setContext(Context context) {
        this.context = context;
    }

    Activity getActivity() {
        return activity;
    }

    void setActivity(Activity activity) {
        this.activity = activity;
    }

}
