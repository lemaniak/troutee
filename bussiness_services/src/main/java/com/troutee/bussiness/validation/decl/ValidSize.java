package com.troutee.bussiness.validation.decl;

import com.troutee.bussiness.validation.impl.ValidSizeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by vicente on 04/04/16.
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidSizeValidator.class)
@Documented
public @interface ValidSize {
    String message() default "{troutee.general.error}";

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};

    int min() default 0;

    int max() default 2147483647;

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ValidSize[] value();
    }
}
