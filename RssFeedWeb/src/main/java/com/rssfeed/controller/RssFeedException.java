package com.rssfeed.controller;

public class RssFeedException extends Exception {
	
		/**
		 * serialVersionUID declared as long.
		 */
		private static final long serialVersionUID = 5811262288L;
		/**
		 * errorCode declared as int.
		 */
		private int errorCode;
		/**
		 * myException is an Throwable obj.
		 */
		private Throwable myException;

		// private String errorMessage = null;
		/**
		 * Constructor.
		 */
		public RssFeedException()
		{
			super();

		}

		/**
		 * constructor.
		 * 
		 * @param errorMessage
		 *            String
		 * @param errorCause
		 *            Throwable
		 */
		public RssFeedException(String errorMessage, Throwable errorCause)
		{
			super(errorMessage, errorCause);

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
		public RssFeedException(String errorMessage, int errorCode, Throwable errorCause)
		{
			super(errorMessage, errorCause);
			this.errorCode = errorCode;
		}

		/**
		 * Constructor.
		 * 
		 * @param errorMessage
		 *            String
		 */
		public RssFeedException(String errorMessage)
		{
			super(errorMessage);

		}

		/**
		 * Constructor.
		 * 
		 * @param errorCause
		 *            Throwable
		 */
		public RssFeedException(Throwable errorCause)
		{
			super(errorCause);

		}

		/**
		 * getter for error code.
		 * 
		 * @return int
		 */
		public int getErrorCode()
		{
			return errorCode;
		}

		/**
		 * setter for error code.
		 * 
		 * @param errorCode
		 *            int
		 */
		public void setErrorCode(int errorCode)
		{
			this.errorCode = errorCode;
		}

		/**
		 * getter for myException.
		 * 
		 * @return Throwable
		 */
		public Throwable getMyException()
		{
			return myException;
		}

		/**
		 * setter for myException.
		 * 
		 * @param myException
		 *            Throwable
		 */
		public void setMyException(Throwable myException)
		{
			this.myException = myException;
		}
	

}
