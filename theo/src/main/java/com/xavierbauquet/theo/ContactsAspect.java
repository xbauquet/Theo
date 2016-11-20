package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ContactsAspect {
    @Pointcut("execution(@com.xavierbauquet.theo.annotations.GetAccounts * *(..))")
    public void getAccounts() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.ReadContacts * *(..))")
    public void readContacts() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.WriteContacts * *(..))")
    public void writeContacts() {
    }

    @Pointcut("within(android.app.Activity+)")
    public void withinActivity() {
    }

    @Before("getAccounts() && withinActivity()")
    public void getAccountsAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.GET_ACCOUNTS);
    }

    @Before("readContacts() && withinActivity()")
    public void readContactsAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.READ_CONTACTS);
    }

    @Before("writeContacts() && withinActivity()")
    public void writeContactsAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.WRITE_CONTACTS);
    }
}
