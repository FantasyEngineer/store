package com.cy.store.controller.ex;

/**
 * 文件为空
 *
 * @author jimmy
 */
public class FileTypeException extends FileUploadException {

    public FileTypeException() {
        super("文件类型异常");
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
