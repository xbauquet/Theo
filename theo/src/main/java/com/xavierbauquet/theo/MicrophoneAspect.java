package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MicrophoneAspect extends com.xavierbauquet.theo.Aspect {

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.microphone.RecordAudio * *(..))")
    public void microphone() {
    }

    @Before("microphone() && withinActivity()")
    public void microphoneAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.RECORD_AUDIO);
    }
}
