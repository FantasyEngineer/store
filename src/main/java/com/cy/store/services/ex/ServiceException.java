package com.cy.store.services.ex;

/**
 * 业务层异常的基类,throw new ServiceException()
 * 根据业务层不同的功能，来定义具体的异常的类型。 统一的去继承serviceException异常类
 * @author jimmy
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
