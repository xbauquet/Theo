package com.xavierbauquet.theo.annotations.sms;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Annotation throwing Send Sms Permission request
 */
@Retention(CLASS)
@Target({METHOD, CONSTRUCTOR})
public @interface SendSms {
}
