package com.aswini.WebFluxExample.Exceptions;

@SuppressWarnings("serial")
public class InvalidValueException extends RuntimeException {
	 	private String errCode;
	    private String errMessage;
	    public InvalidValueException(String errCode, String errMessage) {
			super();
			this.errCode = errCode;
			this.errMessage = errMessage;
		}
		public InvalidValueException() {}
		public String getErrCode() {
			return errCode;
		}
		public void setErrCode(String errCode) {
			this.errCode = errCode;
		}
		public String getErrMessage() {
			return errMessage;
		}
		public void setErrMessage(String errMessage) {
			this.errMessage = errMessage;
		}
		
		

}
