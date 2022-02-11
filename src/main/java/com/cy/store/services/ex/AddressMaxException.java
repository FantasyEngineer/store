package com.cy.store.services.ex;

/**
 * 数据库更新异常
 *
 * @author jimmy
 */
public class AddressMaxException extends ServiceException {
    public AddressMaxException() {
        super("地址数达到最大数量");
    }

    public AddressMaxException(String message) {
        super(message);
    }

    public AddressMaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressMaxException(Throwable cause) {
        super(cause);
    }

    protected AddressMaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
