package com.xavierbauquet.theo;

import com.xavierbauquet.theo.annotations.Permissions;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class PermissionsAspect extends com.xavierbauquet.theo.Aspect{

    @Pointcut("execution(* *(..))")
    public void permissions() {
    }

    @Before("permissions() && withinActivity() && @annotation(permissionsAnnotation)")
    public void permissionsAspect(JoinPoint joinPoint, Permissions permissionsAnnotation) throws Throwable {
        String[] permissionsList = permissionsAnnotation.value();
        Theo.askPermissionsToActivity(joinPoint, permissionsList);
    }
}
