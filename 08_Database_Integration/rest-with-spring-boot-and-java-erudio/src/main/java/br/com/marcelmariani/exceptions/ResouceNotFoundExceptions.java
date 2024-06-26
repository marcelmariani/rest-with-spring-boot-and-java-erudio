package br.com.marcelmariani.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResouceNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResouceNotFoundExceptions(String ex) {
		super(ex);
	}

}