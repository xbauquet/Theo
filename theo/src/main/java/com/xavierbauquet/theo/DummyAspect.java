package com.xavierbauquet.theo;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DummyAspect {

    @Pointcut("execution(@com.xavierbauquet.theo.DummyAnnotation * *(..))")
    public void method() {}

    @Around("method()")
    public Object aspectMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        Object result = joinPoint.proceed();
        Log.e("DummyAnnotation", "A method annotated with @DummyAnnotation has been called");
        return result;
    }

}
