package com.pavnik.aspectexception;


public class ItemNotFoundException  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param message
	 */
	public ItemNotFoundException( String message )
	{
		super(message);
	}

}
