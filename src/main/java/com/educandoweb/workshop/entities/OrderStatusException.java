package com.educandoweb.workshop.entities;

public class OrderStatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static final String INVALID_CODE = "There is no OrderStatus with this code!";
	
	public OrderStatusException(String msg) {
		super(msg);
	}

}
