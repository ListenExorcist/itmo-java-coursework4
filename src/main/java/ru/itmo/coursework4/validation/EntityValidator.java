package ru.itmo.coursework4.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class EntityValidator {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public <T> void validate(T entity) {
        Set<ConstraintViolation<T>> cvs = validator.validate(entity);
        if (!cvs.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder();
            for (ConstraintViolation<T> cv : cvs) {
                errorMessage.append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append("\n");
            }
            throw new RuntimeException(errorMessage.toString());
        }
    }
}
