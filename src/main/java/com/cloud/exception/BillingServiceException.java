/**
 * 
 */
package com.cloud.exception;

/**
 * @author Ravi
 *
 */
public class BillingServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BillingServiceException() {
	}

	/**
	 * @param message
	 */
	public BillingServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BillingServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BillingServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BillingServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
