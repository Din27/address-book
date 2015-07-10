package com.chelyadin.test.address_book.validation;

import com.chelyadin.test.address_book.domain.Address;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @author Dmitriy Chelyadin
 */
public class PhonesValidator implements ConstraintValidator<Phones, List<String>> {
    private static final String PATTERN = "^[\\+\\d\\s\\(]?[\\-\\d\\s\\(\\)]{1,30}$";

    @Override
    public void initialize(Phones phones) {
    }

    @Override
    public boolean isValid(List<String> phones, ConstraintValidatorContext cxt) {

        if (phones == null || phones.isEmpty()) {
            return false;
        }
        for (String phone : phones) {
            if (phone.length() > Address.MAX_PHONE_SIZE) {
                return false;
            }
            if (!phone.matches(PATTERN)) {
                return false;
            }
        }
        return true;
    }

}