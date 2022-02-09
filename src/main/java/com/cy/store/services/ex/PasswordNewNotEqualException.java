package com.cy.store.services.ex;

/**
 * 老密码不一致
 *
 * @author jimmy
 */
public class PasswordNewNotEqualException extends ServiceException {
    public PasswordNewNotEqualException() {
        super("新密码不一致");
    }

    public PasswordNewNotEqualException(String message) {
        super(message);
    }

    public PasswordNewNotEqualException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNewNotEqualException(Throwable cause) {
        super(cause);
    }

    protected PasswordNewNotEqualException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
