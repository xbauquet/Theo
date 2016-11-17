package com.xavierbauquet.theo.camera;

import android.Manifest;

import com.xavierbauquet.theo.Theo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CameraAspect {

    @Pointcut("execution(@com.xavierbauquet.theo.camera.Camera * *(..))")
    public void camera() {
    }

    @Around("camera()")
    public Object aspectMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Theo.getPermissionProvider().requestPermissions(new String[]{Manifest.permission.CAMERA});
        return joinPoint.proceed();
    }
}
