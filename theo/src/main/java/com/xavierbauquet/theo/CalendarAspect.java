package com.xavierbauquet.theo;

import android.Manifest;

import com.xavierbauquet.theo.Theo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalendarAspect {

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.ReadCalendar * *(..))")
    public void readCalendar() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.WriteCalendar * *(..))")
    public void writeCalendar() {
    }

    @Pointcut("within(android.app.Activity+)")
    public void withinActivity() {
    }

    @Before("readCalendar() && withinActivity()")
    public void readCalendarAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.READ_CALENDAR);
    }

    @Before("writeCalendar() && withinActivity()")
    public void writeCalendarAspect(JoinPoint joinPoint) throws Throwable {
        Theo.askSinglePermissionToActivity(joinPoint, Manifest.permission.WRITE_CALENDAR);
    }

}
