package org.mix3.framework;

@SuppressWarnings("serial")
public class Mix3RuntimeException extends RuntimeException{
	public Mix3RuntimeException() {
		super();
	}
	public Mix3RuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
	public Mix3RuntimeException(String message) {
		super(message);
	}

	public Mix3RuntimeException(Throwable cause) {
		super(cause);
	}
}
