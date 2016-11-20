package com.xavierbauquet.theo;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import org.aspectj.lang.JoinPoint;

public class Theo {

    final public static int REQUEST_CODE = 987;

    static void askSinglePermissionToActivity(JoinPoint joinPoint, String permission) {
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = (Context) joinPoint.getTarget();
            Activity activity = (Activity) joinPoint.getTarget();
            new PermissionProvider(context, activity).requestPermissions(new String[]{permission});
        }
    }
}
