package com.troutee.bussiness.validation.decl;

import com.troutee.bussiness.validation.impl.ValidClientIdValidator;
import com.troutee.bussiness.validation.impl.ValidTokenValidator;

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
@Constraint(validatedBy = ValidClientIdValidator.class)
@Documented
public @interface ValidClientId {

    String message() default "{client.id.invalid}";

    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ValidClientId[] value();
    }
}
