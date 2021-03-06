package com.dch.core.dto.validator.constraint;

import com.dch.core.dto.validator.UniqueEmail;
import com.dch.core.dto.validator.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Checks that a given string is a unique email.
 *
 * @author David.Christianto
 * @version 2.0.0
 * @see javax.validation.ConstraintValidator
 * @since 1.0.0
 */
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private ApplicationContext applicationContext;

    private String serviceName;

    @Override
    public void initialize(UniqueEmail annotation) {
        this.serviceName = annotation.serviceName();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtils.hasLength(value))
            return false;

        ValidatorService validatorService = applicationContext.getBean(serviceName, ValidatorService.class);
        return validatorService.isValidCode(value);
    }
}
