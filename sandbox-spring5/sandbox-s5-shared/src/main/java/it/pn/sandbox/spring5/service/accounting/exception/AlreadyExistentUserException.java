/*
 * File AlreadyExistentUserException.java of project sandbox-s5-shared.
 * File created on 16 ott 2017 at 23:09:16 at PN-HQ.
 */
package it.pn.sandbox.spring5.service.accounting.exception;

/**
 * Class AlreadyExistentUserException representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public class AlreadyExistentUserException extends Exception {

    /**
     * Field serialVersionUID:long representing ...
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the class.
     *
     */
    public AlreadyExistentUserException() {
	// empty
    }

    /**
     * Constructor for the class.
     *
     * @param message
     */
    public AlreadyExistentUserException(String message) {
	super(message);
    }

    /**
     * Constructor for the class.
     *
     * @param cause
     */
    public AlreadyExistentUserException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructor for the class.
     *
     * @param message
     * @param cause
     */
    public AlreadyExistentUserException(String message, Throwable cause) {
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
    public AlreadyExistentUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }
}
