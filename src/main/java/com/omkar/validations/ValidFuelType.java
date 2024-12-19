package com.omkar.validations;

import jakarta.validation.Payload;

public @interface ValidFuelType {
    String message() default "Invalid Fuel Type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
