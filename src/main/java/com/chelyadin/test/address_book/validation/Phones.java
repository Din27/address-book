package com.chelyadin.test.address_book.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Dmitriy Chelyadin
 */
@Constraint(validatedBy = PhonesValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phones {


    String message() default "There are incorrect phones";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}