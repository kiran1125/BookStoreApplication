package com.book.library.exceptions;

import java.util.Locale;

import com.book.library.Util.ErrorResponse;
import com.book.library.Util.Response;

import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;

@ResponseStatus
@Data
public class UserRegisrationException extends RuntimeException {
    private int StatusCode;
	private String Statusmessage;
    private static final long serialVersionUID = 1L;

    public UserRegisrationException(int statusCode, String statusmessage) {
		super(statusmessage);
		this.StatusCode = statusCode;
		this.Statusmessage = statusmessage;
	}

    public Response getErrorResponse() {
		return getErrorResponse(Locale.getDefault());
	}
	public Response getErrorResponse(Locale locale) {
		ErrorResponse err = new ErrorResponse(StatusCode, Statusmessage, getStackTrace());
		err.setStatusCode(getStatusCode());
		err.setStatusmessage(getStatusmessage());

		return err;
	

}
}
