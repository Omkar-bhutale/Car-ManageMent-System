package com.omkar.validations;

import com.omkar.model.FuelType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FuelTypeValidator implements ConstraintValidator<ValidFuelType, FuelType> {

    @Override
    public boolean isValid(FuelType fuelType, ConstraintValidatorContext constraintValidatorContext) {
        if (fuelType == null) {
            return false;
        }
        return fuelType.equals(FuelType.PETROL) || fuelType.equals(FuelType.DIESEL) || fuelType.equals(FuelType.ELECTRIC) || fuelType.equals(FuelType.HYBRID);
    }
}
