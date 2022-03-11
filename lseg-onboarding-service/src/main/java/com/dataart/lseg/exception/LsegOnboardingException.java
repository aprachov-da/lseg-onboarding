package com.dataart.lseg.exception;

public abstract class LsegOnboardingException extends RuntimeException {

    public LsegOnboardingException() {
    }

    public LsegOnboardingException(String message) {
        super(message);
    }

    public LsegOnboardingException(String message, Object... messageParams) {
        super(String.format(message, messageParams));
    }

    public LsegOnboardingException(String message, Throwable cause) {
        super(message, cause);
    }

    public LsegOnboardingException(Throwable cause) {
        super(cause);
    }
}
