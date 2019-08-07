package com.akhil.ecom.exception;
/**
 * 
 * @author akhil
 *
 */
public class EcomException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public EcomException() {
        super();
    }

    public EcomException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public EcomException(final String message) {
        super(message);
    }

    public EcomException(final Throwable cause) {
        super(cause);
    }
}