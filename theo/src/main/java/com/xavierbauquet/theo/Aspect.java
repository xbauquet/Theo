package com.xavierbauquet.theo;

import org.aspectj.lang.annotation.Pointcut;

public abstract class Aspect {

    @Pointcut("within(android.app.Activity+)")
    public void withinActivity() {
    }
}
