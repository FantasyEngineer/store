package com.cy.store.services.ex;

/**
 *
 * 用户名被占用异常
 * @author jimmy
 */
public class UserNameDuplicatedException extends ServiceException {

    public UserNameDuplicatedException() {
        super("用户名被占用");
    }

    public UserNameDuplicatedException(String message) {
        super(message);
    }

    public UserNameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected UserNameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
