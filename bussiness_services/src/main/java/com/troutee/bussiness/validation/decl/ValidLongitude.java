package com.troutee.bussiness.validation.decl;


import com.troutee.bussiness.validation.impl.ValidLatitudeValidator;
import com.troutee.bussiness.validation.impl.ValidLongitudeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by vicente on 29/02/16.
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
    @Constraint(validatedBy = ValidLongitudeValidator.class)
@Documented
public @interface ValidLongitude {
    String message() default "{client.coordinate.invalid}";

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ValidLongitude[] value();
    }
}
