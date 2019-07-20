package com.sny.app.payload;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ApiResponse
{
	private int status;
    private String message;
    private Object data;
    private String error;
    private Boolean isResponseOnPage;
 
   public ApiResponse(int status, String message, Object data, String error, Boolean isResponseOnPage)
   {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.error = error;
		this.isResponseOnPage = isResponseOnPage;
	}
	
	public ApiResponse() {
		super();
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
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Boolean getIsResponseOnPage() {
		return isResponseOnPage;
	}
	public void setIsResponseOnPage(Boolean isResponseOnPage) {
		this.isResponseOnPage = isResponseOnPage;
	}
    
    
  
}
