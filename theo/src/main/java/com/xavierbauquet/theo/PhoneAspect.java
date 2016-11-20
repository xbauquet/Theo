package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PhoneAspect extends com.xavierbauquet.theo.Aspect {

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.phone.AddVoiceMail * *(..))")
    public void addVoiceMail() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.phone.CallPhone * *(..))")
    public void callPhone() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.phone.ProcessOutgoingCalls * *(..))")
    public void processOutgoingCalls() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.phone.ReadCallLog * *(..))")
    public void readCallLog() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.phone.ReadPhoneState * *(..))")
    public void readPhoneState() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.phone.UseSip * *(..))")
    public void useSip() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.phone.WriteCallLog * *(..))")
    public void writeCallLog() {
    }

    @Before("addVoiceMail() && withinActivity()")
    public void addVoiceMailAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.ADD_VOICEMAIL);
    }

    @Before("callPhone() && withinActivity()")
    public void callPhoneAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.CALL_PHONE);
    }

    @Before("processOutgoingCalls() && withinActivity()")
    public void processOutgoingCallsAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.PROCESS_OUTGOING_CALLS);
    }

    @Before("readCallLog() && withinActivity()")
    public void readCallLogAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.READ_CALL_LOG);
    }

    @Before("readPhoneState() && withinActivity()")
    public void readPhoneStateAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.READ_PHONE_STATE);
    }

    @Before("useSip() && withinActivity()")
    public void useSipAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.USE_SIP);
    }

    @Before("writeCallLog() && withinActivity()")
    public void writeCallLogAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.WRITE_CALL_LOG);
    }
}
