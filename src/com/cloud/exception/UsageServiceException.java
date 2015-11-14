/**
 * 
 */
package com.cloud.exception;

/**
 * @author Ravi
 *
 */
public class UsageServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UsageServiceException() {
	}

	/**
	 * @param message
	 */
	public UsageServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UsageServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UsageServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UsageServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
