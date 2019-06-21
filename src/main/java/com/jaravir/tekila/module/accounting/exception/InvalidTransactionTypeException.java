package com.jaravir.tekila.module.accounting.exception;

public class InvalidTransactionTypeException extends IllegalArgumentException {

	private static final long serialVersionUID = 3748181317261491805L;
	
	public InvalidTransactionTypeException () {}
	
	public InvalidTransactionTypeException (String message) {
		super(message);
	}
	
	public InvalidTransactionTypeException (Throwable th) {
		super(th);
	}
	
	public InvalidTransactionTypeException (String message, Throwable th) {
		super(message, th);
	}
}
