package com.xavierbauquet.theo.microphone;

import android.Manifest;

import com.xavierbauquet.theo.Utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MicrophoneAspect {
    @Pointcut("execution(@com.xavierbauquet.theo.microphone.RecordAudio * *(..))")
    public void microphone() {
    }

    @Pointcut("within(android.app.Activity+)")
    public void withinActivity() {
    }

    @Before("microphone() && withinActivity()")
    public void microphoneAspect(JoinPoint joinPoint) throws Throwable {
        Utils.askSinglePermissionToActivity(joinPoint, Manifest.permission.RECORD_AUDIO);
    }
}
