package id.newsservice.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponse {
	
	private String status;
	private Object data;
	private MetaResponse metaData;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public MetaResponse getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaResponse metaData) {
		this.metaData = metaData;
	}
	public CustomResponse(String status, Object data, MetaResponse metaData) {
		super();
		this.status = status;
		this.data = data;
		this.metaData = metaData;
	}
	
	public CustomResponse() {
		
	}
	
	public ResponseEntity notFound() {
		MetaResponse meta = new MetaResponse(HttpStatus.NOT_FOUND.value(), "Data doen't exist", "");
		CustomResponse res = new CustomResponse("ERROR", null, meta);
		
		return new ResponseEntity(res, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity notFound(String message) {
		MetaResponse meta = new MetaResponse(HttpStatus.NOT_FOUND.value(), message, "");
		CustomResponse res = new CustomResponse("ERROR", null, meta);
		
		return new ResponseEntity(res, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity badRequest(String message) {
		MetaResponse meta = new MetaResponse(HttpStatus.BAD_REQUEST.value(), message, "");
		CustomResponse res = new CustomResponse("ERROR", null, meta);
		
		return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity badRequest() {
		MetaResponse meta = new MetaResponse(HttpStatus.BAD_REQUEST.value(), "Bad request", "");
		CustomResponse res = new CustomResponse("ERROR", null, meta);
		
		return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity success(String message, Object data) {
		MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), message, "");
		CustomResponse res = new CustomResponse("OK", data, meta);
		
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	public ResponseEntity success(Object data) {
		MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), "Success", "");
		CustomResponse res = new CustomResponse("OK", data, meta);
		
		return new ResponseEntity(res, HttpStatus.OK);
	}
	
	public ResponseEntity success(String message) {
		MetaResponse meta = new MetaResponse(HttpStatus.OK.value(), message, "");
		CustomResponse res = new CustomResponse("OK", null, meta);
		
		return new ResponseEntity(res, HttpStatus.OK);
	}

}
