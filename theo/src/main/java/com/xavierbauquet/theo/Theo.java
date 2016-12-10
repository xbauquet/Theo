package com.xavierbauquet.theo;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import org.aspectj.lang.JoinPoint;

public class Theo {

    final public static int REQUEST_CODE = 987;

    static void askSinglePermissionToActivity(JoinPoint joinPoint, String permission) {
        askPermissionsToActivity(joinPoint, new String[]{permission});
    }

    static void askPermissionsToActivity(JoinPoint joinPoint, String[] permissions) {
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = (Context) joinPoint.getTarget();
            Activity activity = (Activity) joinPoint.getTarget();
            new PermissionProvider(context, activity).requestPermissions(permissions);
        }
    }

    public static boolean checkPermission(Activity activity, String permission){
        return checkPermission(activity, new String[]{permission}, true);
    }

    public static boolean checkPermission(Activity activity, String[] permissions){
        return checkPermission(activity, permissions, true);
    }

    public static boolean checkPermission(Activity activity, String permission, boolean snackbar){
        return checkPermission(activity, new String[]{permission}, snackbar);
    }

    public static boolean checkPermission(Activity activity, String[] permissions, boolean snackbar){
        return new PermissionProvider(activity, activity).isPermissionGranted(permissions, snackbar);
    }
}
