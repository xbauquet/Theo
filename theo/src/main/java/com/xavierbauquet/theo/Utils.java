package com.xavierbauquet.theo;

import android.app.Activity;
import android.content.Context;

import com.xavierbauquet.theo.permission.PermissionProvider;

import org.aspectj.lang.JoinPoint;

public class Utils {

    public static void askSinglePermissionToActivity(JoinPoint joinPoint, String permission) {
        Context context = (Context) joinPoint.getTarget();
        Activity activity = (Activity) joinPoint.getTarget();
        new PermissionProvider(context, activity).requestPermissions(new String[]{permission});
    }
}
