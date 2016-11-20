package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ContactsAspect extends com.xavierbauquet.theo.Aspect {
    @Pointcut("execution(@com.xavierbauquet.theo.annotations.contacts.GetAccounts * *(..))")
    public void getAccounts() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.contacts.ReadContacts * *(..))")
    public void readContacts() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.contacts.WriteContacts * *(..))")
    public void writeContacts() {
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
