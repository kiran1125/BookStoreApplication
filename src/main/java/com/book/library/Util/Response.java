package com.book.library.Util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private Integer StatusCode;
	private String Statusmessage;
	private Object token;
	
    public Response(int i, String string) {
		super();
		StatusCode = i;
		Statusmessage = string;
    }
}
