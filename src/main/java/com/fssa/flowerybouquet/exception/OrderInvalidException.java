package com.fssa.flowerybouquet.exception;

public class OrderInvalidException extends Exception {
  
	private static final long serialVersionUID = 2L;
	public OrderInvalidException(String msg) {
		super(msg);
	}

	public OrderInvalidException(Throwable te) {
		super(te);
	}

	public OrderInvalidException(String msg, Throwable te) {

		super(msg, te);
	}
	
}
