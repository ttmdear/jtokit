package com.jtokit.validation;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class NotEmptyValidator {

    public boolean validate(@Nullable String email) {
        return email != null && !(email.trim()).isEmpty();
    }
}
