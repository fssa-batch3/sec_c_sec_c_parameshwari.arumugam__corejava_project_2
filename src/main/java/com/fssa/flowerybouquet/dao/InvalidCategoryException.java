package com.fssa.flowerybouquet.dao;

public class InvalidCategoryException extends RuntimeException  {
   
	private static final long serialVersionUID = -8105491977357554060L;

	public InvalidCategoryException(String msg) {
		super(msg);
	}	 
 
	public InvalidCategoryException(Throwable te) {
		super(te);
	} 

	public InvalidCategoryException(String msg, Throwable te) {
		super(msg, te);
	}
	
}
