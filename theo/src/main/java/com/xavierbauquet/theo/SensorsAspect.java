package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SensorsAspect extends com.xavierbauquet.theo.Aspect {

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.sensors.BodySensors * *(..))")
    public void bodySensors() {
    }

    @Before("bodySensors() && withinActivity()")
    public void bodySensorsAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.BODY_SENSORS);
    }
}
