package com.xavierbauquet.theo;

import android.app.Activity;

import com.xavierbauquet.theo.permission.PermissionProvider;

public class Theo {

    private static Theo instance = new Theo();
    private static PermissionProvider permissionProvider = new PermissionProvider();

    private Theo() {
    }

    public static Theo getInstance() {
        return instance;
    }

    public static PermissionProvider getPermissionProvider() {
        return permissionProvider;
    }

    public static Theo build(Activity activity) {
        permissionProvider.setContext(activity);
        permissionProvider.setActivity(activity);
        return instance;
    }

    public static Theo setListener(TheoListener listener) {
        permissionProvider.setListener(listener);
        return instance;
    }
}
