package com.letstravel.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5815555253870472445L;

	public NotFoundException(String msg) {
		super(msg);
	}
}
