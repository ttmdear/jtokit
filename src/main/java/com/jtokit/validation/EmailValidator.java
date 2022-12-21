package com.jtokit.validation;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class EmailValidator {

    private final String PATTERN = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[a-z]+";

    public boolean validate(String email) {
        return email.matches(PATTERN);
    }
}
