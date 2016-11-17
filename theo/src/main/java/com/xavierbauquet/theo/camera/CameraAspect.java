package com.xavierbauquet.theo.camera;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import com.xavierbauquet.theo.permission.PermissionProvider;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CameraAspect {

    @Pointcut("execution(@com.xavierbauquet.theo.camera.Camera * *(..)) && within(android.app.Activity+)")
    public void camera() {
    }

    @Around("camera()")
    public Object aspectMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Context context = (Context) joinPoint.getTarget();
        Activity activity = (Activity) joinPoint.getTarget();
        new PermissionProvider(context, activity).requestPermissions(new String[]{Manifest.permission.CAMERA});
        return joinPoint.proceed();
    }
}
