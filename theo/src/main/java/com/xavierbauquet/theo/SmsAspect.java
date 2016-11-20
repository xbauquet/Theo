package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SmsAspect extends com.xavierbauquet.theo.Aspect {

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.sms.ReadSms * *(..))")
    public void readSms() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.sms.ReceiveMms * *(..))")
    public void receiveMms() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.sms.ReceiveSms * *(..))")
    public void receiveSms() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.sms.ReceiveWapPush * *(..))")
    public void receiveWapPush() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.sms.SendSms * *(..))")
    public void sendSms() {
    }

    @Before("readSms() && withinActivity()")
    public void readSmsAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.READ_SMS);
    }

    @Before("receiveMms() && withinActivity()")
    public void receiveMmsAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.RECEIVE_MMS);
    }

    @Before("receiveSms() && withinActivity()")
    public void receiveSmsAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.RECEIVE_SMS);
    }

    @Before("receiveWapPush() && withinActivity()")
    public void receiveWapPushAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.RECEIVE_WAP_PUSH);
    }

    @Before("sendSms() && withinActivity()")
    public void sendSmsAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.SEND_SMS);
    }
}
