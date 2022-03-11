package com.dataart.lseg.exception;

import java.util.UUID;

public class LicenseNotFoundException extends LsegOnboardingException {

    private static final String MESSAGE = "License with id: %s is not found";

    public LicenseNotFoundException(UUID entityId) {
        super(MESSAGE, entityId);
    }
}
