package id.newsservice.response;

public class Response {
	
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
	public Response(String status, Object data, MetaResponse metaData) {
		super();
		this.status = status;
		this.data = data;
		this.metaData = metaData;
	}

}
