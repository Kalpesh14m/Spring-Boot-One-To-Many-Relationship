package com.bunny.config.response;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class Response {

	private int status;
	private String message;
	private Object data;
	private LocalDateTime now;

	public Response() {
	}

	public Response(String message) {
		this.message = message;
	}

	public Response(String message, int status) {
		this.message = message;
		this.status = status;
	}

	public Response(String message, int status, Object data) {
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public Response(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Response(LocalDateTime now, String message, int status) {
		this.message = message;
		this.status = status;
		this.setNow(now);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public LocalDateTime getNow() {
		return now;
	}

	public void setNow(LocalDateTime now) {
		this.now = now;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + "]";
	}

}