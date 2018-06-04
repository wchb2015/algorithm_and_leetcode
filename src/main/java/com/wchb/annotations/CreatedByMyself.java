package com.wchb.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @date 6/4/18 11:27 AM
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface CreatedByMyself {
}
