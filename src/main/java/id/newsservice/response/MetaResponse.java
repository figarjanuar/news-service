package id.newsservice.response;

public class MetaResponse {
	
	private int code;
	private String message;
	private String debugInfo;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDebugInfo() {
		return debugInfo;
	}
	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}
	public MetaResponse(int code, String message, String debugInfo) {
		super();
		this.code = code;
		this.message = message;
		this.debugInfo = debugInfo;
	}
	
	

}
