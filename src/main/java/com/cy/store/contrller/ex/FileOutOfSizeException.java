package com.cy.store.contrller.ex;

/**
 * 文件超出大小
 *
 * @author jimmy
 */
public class FileOutOfSizeException extends FileUploadException {

    public FileOutOfSizeException() {
        super("文件超出规定大小10M");
    }

    public FileOutOfSizeException(String message) {
        super(message);
    }

    public FileOutOfSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileOutOfSizeException(Throwable cause) {
        super(cause);
    }

    public FileOutOfSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
