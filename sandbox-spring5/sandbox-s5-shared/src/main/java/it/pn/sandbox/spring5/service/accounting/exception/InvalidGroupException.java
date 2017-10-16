/*
 * File InvalidGroupException.java of project sandbox-s5-shared.
 * File created on 16 ott 2017 at 22:55:57 at PN-HQ.
 */
package it.pn.sandbox.spring5.service.accounting.exception;

/**
 * Class InvalidGroupException representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public class InvalidGroupException extends Exception {

    /**
     * Field serialVersionUID:long representing ...
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the class.
     *
     */
    public InvalidGroupException() {
	// empty
    }

    /**
     * Constructor for the class.
     *
     * @param message
     */
    public InvalidGroupException(String message) {
	super(message);
    }

    /**
     * Constructor for the class.
     *
     * @param cause
     */
    public InvalidGroupException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructor for the class.
     *
     * @param message
     * @param cause
     */
    public InvalidGroupException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Constructor for the class.
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public InvalidGroupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }
}
