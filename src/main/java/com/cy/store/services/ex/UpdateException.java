package com.cy.store.services.ex;

/**
 * 数据库更新异常
 *
 * @author jimmy
 */
public class UpdateException extends ServiceException {
    public UpdateException() {
        super("数据库更新异常");
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    protected UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
