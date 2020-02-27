package org.Myweb.showroom.model;

public class ErrorPayLoad {

	private int statusCode;
	private String errorMsg;
	public ErrorPayLoad(int statusCode, String errorMsg) {
		super();
		this.statusCode = statusCode;
		this.errorMsg = errorMsg;
	}
	public ErrorPayLoad() {
		
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
}
