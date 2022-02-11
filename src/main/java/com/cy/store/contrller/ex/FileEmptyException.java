package com.cy.store.contrller.ex;

/**
 * 文件为空
 *
 * @author jimmy
 */
public class FileEmptyException extends FileUploadException {

    public FileEmptyException() {
        super("文件为空");
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
