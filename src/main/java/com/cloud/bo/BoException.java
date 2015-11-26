package com.cloud.bo;

public class BoException extends Exception {

	public BoException() {
	}

	public BoException(String message) {
		super(message);
	}

	public BoException(Throwable cause) {
		super(cause);
	}

	public BoException(String message, Throwable cause) {
		super(message, cause);
	}

	public BoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
