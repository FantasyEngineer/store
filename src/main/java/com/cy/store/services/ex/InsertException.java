package com.cy.store.services.ex;

/**
 * 数据库插入异常
 *
 * @author jimmy
 */
public class InsertException extends ServiceException {
    public InsertException() {
        super("数据库插入异常");
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
