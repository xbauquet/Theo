package com.xavierbauquet.theo.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation throwing Several Permission requests
 */
@Retention(RUNTIME)
@Target({METHOD, CONSTRUCTOR})
public @interface Permissions {
    String[] value();
}
