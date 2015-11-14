/**
 * 
 */
package com.cloud.exception;

/**
 * @author Ravi
 *
 */
public class AlertsNotificationServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public AlertsNotificationServiceException() {
	}

	/**
	 * @param message
	 */
	public AlertsNotificationServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AlertsNotificationServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AlertsNotificationServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AlertsNotificationServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
