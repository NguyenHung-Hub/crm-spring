package com.hd.spring.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionJSONInfo {
	private int status;
	private String message;
	private long timeStamp;
	
	public ExceptionJSONInfo() {
		this.timeStamp = System.currentTimeMillis();
	}
	
	public ExceptionJSONInfo(int status) {
		this();
		this.status = status;
	}
	
	/**
	 * @param status
	 * @param message
	 * @param timeStamp
	 */
	public ExceptionJSONInfo(int status, Throwable ex) {
		this();
		this.status = status;
		this.message = ex.getMessage();
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "ExceptionJSONInfo [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
}
