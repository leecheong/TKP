package com.marketapp.marketapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//例外をハンドルするクラス

@ControllerAdvice
public class ItemNotFoundExceptionControllerAdvice {

	@ResponseBody //例外をレスポンスとして返すためのアノテーション
	@ExceptionHandler(ItemNotFoundException.class) //ハンドリングするためのアノテーション
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String itemNotFoundHandler (ItemNotFoundException ex) {
		return ex.getMessage();
	}
	
}
