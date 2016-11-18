package com.xavierbauquet.theo.camera;

import android.Manifest;

import com.xavierbauquet.theo.Utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CameraAspect {

    @Pointcut("execution(@com.xavierbauquet.theo.camera.Camera * *(..))")
    public void camera() {
    }

    @Pointcut("within(android.app.Activity+)")
    public void withinActivity() {
    }

    @Before("camera() && withinActivity()")
    public void cameraAspect(JoinPoint joinPoint) throws Throwable {
        Utils.askSinglePermissionToActivity(joinPoint, Manifest.permission.CAMERA);
    }
}
