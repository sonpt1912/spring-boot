package com.example.hibernate_validator.utils;

import com.example.hibernate_validator.models.Employee;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * khai báo một custom annotation
 */

@Documented
@Constraint(validatedBy = EmValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeId {
    // trường message là bắt buộc, khai bo nội dung sẽ trả về khi ko hợp lệ
    String message() default "LodaId must start with loda://";

    // ca này bắt buộc phải có để hibernate validator cos thể hoạt đôộng
    Class<?>[] groups() default {};

    // bắt buộc để hibernate hoạt động;
    Class<? extends Payload>[] payload() default {};

}
