package id.newsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import id.newsservice.response.MetaResponse;
import id.newsservice.response.Response;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception ex) {
		MetaResponse meta = new MetaResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "", ex.getMessage());
		Response res = new Response("ERROR", null, meta);
		
		return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
