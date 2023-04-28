package com.example.hibernate_validator.utils;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmValidator implements ConstraintValidator<EmployeeId, Long> {


    /**
     * kiểm tra tính hợp lệ của trường được đánh dâu @LodaId
     *
     * @param
     * @param constraintValidatorContext
     * @return
     */


    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
        if (aLong == null || aLong == 1) {
            return false;
        }
        return false;
    }


}
