package com.xavierbauquet.theo;

import android.Manifest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalendarAspect extends com.xavierbauquet.theo.Aspect {

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.calendar.ReadCalendar * *(..))")
    public void readCalendar() {
    }

    @Pointcut("execution(@com.xavierbauquet.theo.annotations.calendar.WriteCalendar * *(..))")
    public void writeCalendar() {
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
