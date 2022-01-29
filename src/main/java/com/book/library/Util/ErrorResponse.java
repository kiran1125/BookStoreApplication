package com.book.library.Util;

public class ErrorResponse extends Response {
    public ErrorResponse(Integer statusCode, String statusmessage, Object token) {
		super(statusCode, statusmessage, token);
		
	}

}
