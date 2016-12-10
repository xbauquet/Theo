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

    /**
     * This method check if a permission is granted or not. If not it will throw a snackbar to allow the user to grant the permission
     *
     * @param activity ,   the activity that will be used has context and that will throw the snackbar
     * @param permission , one of the dangerous permissions present in Manifest.permission
     * @return true if the permission is granted
     */
    public static boolean checkPermission(Activity activity, String permission) {
        return checkPermission(activity, new String[]{permission}, true);
    }

    /**
     * This method check if a list of permissions are granted or not. If not it will throw a snackbar to allow the user to grant the permissions
     *
     * @param activity ,    the activity that will be used has context and that will throw the snackbar
     * @param permissions , a list of dangerous permissions present in Manifest.permission
     * @return true if the permission is granted
     */
    public static boolean checkPermission(Activity activity, String[] permissions) {
        return checkPermission(activity, permissions, true);
    }

    /**
     * This method check if a permission is granted or not. If not it will throw a snackbar to allow the user to grant the permission
     *
     * @param activity ,   the activity that will be used has context and that will throw the snackbar
     * @param permission , one of the dangerous permissions present in Manifest.permission
     * @param snackbar ,   Put this boolean at false to avoid the snackbar. Default: true
     * @return true if the permission is granted
     */
    public static boolean checkPermission(Activity activity, String permission, boolean snackbar) {
        return checkPermission(activity, new String[]{permission}, snackbar);
    }

    /**
     * This method check if a list of permissions are granted or not. If not it will throw a snackbar to allow the user to grant the permissions
     *
     * @param activity ,    the activity that will be used has context and that will throw the snackbar
     * @param permissions , a list of dangerous permissions present in Manifest.permission
     * @param snackbar ,    Put this boolean at false to avoid the snackbar. Default: true
     * @return true if the permission is granted
     */
    public static boolean checkPermission(Activity activity, String[] permissions, boolean snackbar) {
        return new PermissionProvider(activity, activity).isPermissionGranted(permissions, snackbar);
    }
}
