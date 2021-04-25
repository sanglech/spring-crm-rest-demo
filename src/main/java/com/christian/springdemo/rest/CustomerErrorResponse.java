package com.christian.springdemo.rest;

public class CustomerErrorResponse {
	private String message;
	private long timeStamp;
	private int status;
	
	public CustomerErrorResponse(){
		
	}
	
	public CustomerErrorResponse(int status,String message, long timeStamp) {
		this.message = message;
		this.timeStamp = timeStamp;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
