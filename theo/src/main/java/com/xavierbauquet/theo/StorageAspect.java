package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StorageAspect extends com.xavierbauquet.theo.Aspect {

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.storage.ReadExternalStorage * *(..))")
    public void readExternalStorage() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.storage.WriteExternalStorage * *(..))")
    public void writeExternalStorage() {
    }

    @Before("readExternalStorage() && withinActivity()")
    public void readExternalStorageAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Before("writeExternalStorage() && withinActivity()")
    public void writeExternalStorageAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }
}
