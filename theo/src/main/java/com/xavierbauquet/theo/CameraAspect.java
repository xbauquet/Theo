package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CameraAspect {

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.Camera * *(..))")
    public void camera() {
    }

    @Pointcut("within(android.app.Activity+)")
    public void withinActivity() {
    }

    @Before("camera() && withinActivity()")
    public void cameraAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.CAMERA);
    }
}
