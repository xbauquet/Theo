package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LocationAspect {

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.AccessCoarseLocation * *(..))")
    public void accessCoarseLocation() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.AccessFineLocation * *(..))")
    public void accessFineLocation() {
    }

    @Pointcut("within(android.app.Activity+)")
    public void withinActivity() {
    }

    @Before("accessCoarseLocation() && withinActivity()")
    public void accessCoarseLocationAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.ACCESS_COARSE_LOCATION);
    }

    @Before("accessFineLocation() && withinActivity()")
    public void accessFineLocationAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.ACCESS_FINE_LOCATION);
    }
}
