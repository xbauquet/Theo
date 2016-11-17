package com.xavierbauquet.theo.location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import com.xavierbauquet.theo.permission.PermissionProvider;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LocationAspect {

    @Pointcut("execution(@com.xavierbauquet.theo.location.AccessCoarseLocation * *(..))")
    public void accessCoarseLocation() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.location.AccessFineLocation * *(..))")
    public void accessFineLocation() {
    }

    @Around("accessCoarseLocation()")
    public Object accessCoarseLocationAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        Context context = (Context) joinPoint.getTarget();
        Activity activity = (Activity) joinPoint.getTarget();
        new PermissionProvider(context, activity).requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION});
        return joinPoint.proceed();
    }

    @Around("accessFineLocation()")
    public Object accessFineLocationAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        Context context = (Context) joinPoint.getTarget();
        Activity activity = (Activity) joinPoint.getTarget();
        new PermissionProvider(context, activity).requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION});
        return joinPoint.proceed();
    }
}
