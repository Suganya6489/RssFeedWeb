package com.rssfeed.controller;


public class RssFeedWebSqlException extends Exception
{

	/**
	 *  serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * errorCode declared as int.
	 */
	private int errorCode;

	/**
	 *  This method returns the error code of exception.
	 * @return the errorCode
	 */
	public final int getErrorCode()
	{
		return errorCode;
	}

	/**
	 * this method can be used to set error code for the excpetion.
	 * @param errorCode
	 *            the errorCode to set
	 */
	public final void setErrorCode(int errorCode)
	{
		this.errorCode = errorCode;
	}

	/**
	 * constructor with two arguments.
	 * @param message
	 *            the message to be displayed to the user
	 * @param cause
	 *            the cause of the exception
	 */
	public RssFeedWebSqlException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * constructor.
	 * 
	 * @param errorMessage
	 *            .
	 * @param errorCode
	 *            .
	 * @param errorCause
	 *            .
	 */
	public RssFeedWebSqlException(String errorMessage, int errorCode, Throwable errorCause)
	{
		super(errorMessage, errorCause);
		this.errorCode = errorCode;
	}

	/**
	 * constructor with one argument.
	 * 
	 * @param cause
	 *            the cause of the exception
	 */

	public RssFeedWebSqlException(Throwable cause)
	{
		super(cause);
	}
	
	/**
	 * Default constructor.
	 */
	public RssFeedWebSqlException()
	{
	}

	/**
	 * Single argument constructor.
	 * 
	 * @param s
	 *            message to be displayed
	 */

	public RssFeedWebSqlException(String s)
	{
		super(s);
	}

	/**
	 * constructor.
	 * 
	 * @param errorMessage
	 *            .
	 * @param errorCode
	 * 				.
	 */
	public RssFeedWebSqlException(String errorMessage, int errorCode)
	{
		super(errorMessage);
		this.errorCode = errorCode;
	}

}
