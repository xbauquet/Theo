package com.xavierbauquet.theo;

import org.aspectj.lang.annotation.Pointcut;

abstract class Aspect {

    @Pointcut("within(android.app.Activity+)")
    void withinActivity() {
    }
}
