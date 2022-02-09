package com.cy.store.services.ex;

/**
 * 老密码不一致
 *
 * @author jimmy
 */
public class PasswordNotInconsistentException extends ServiceException {
    public PasswordNotInconsistentException() {
        super("老密码不一致");
    }

    public PasswordNotInconsistentException(String message) {
        super(message);
    }

    public PasswordNotInconsistentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotInconsistentException(Throwable cause) {
        super(cause);
    }

    protected PasswordNotInconsistentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
