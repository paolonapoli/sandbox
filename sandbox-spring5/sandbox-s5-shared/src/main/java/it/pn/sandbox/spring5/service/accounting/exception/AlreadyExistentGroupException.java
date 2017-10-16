/*
 * File AlreadyExistentGroupException.java of project sandbox-s5-shared.
 * File created on 16 ott 2017 at 23:06:00 at PN-HQ.
 */
package it.pn.sandbox.spring5.service.accounting.exception;

/**
 * Class AlreadyExistentGroupException representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public class AlreadyExistentGroupException extends Exception {

    /**
     * Field serialVersionUID:long representing ...
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the class.
     *
     */
    public AlreadyExistentGroupException() {
	// empty
    }

    /**
     * Constructor for the class.
     *
     * @param message
     */
    public AlreadyExistentGroupException(String message) {
	super(message);
    }

    /**
     * Constructor for the class.
     *
     * @param cause
     */
    public AlreadyExistentGroupException(Throwable cause) {
	super(cause);
    }

    /**
     * Constructor for the class.
     *
     * @param message
     * @param cause
     */
    public AlreadyExistentGroupException(String message, Throwable cause) {
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
    public AlreadyExistentGroupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }
}
