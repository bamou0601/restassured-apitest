package utils;

public class ImageCheckResult {
	
	public final String url;
	public final boolean uiOK;
	public final int statusCode;
	
	public ImageCheckResult(String url, boolean uiOK, int statusCode) {
		this.url = url;
		this.uiOK = uiOK;
		this.statusCode = statusCode;
	}
	
	public boolean isHealthy() {
		return uiOK && statusCode == 200;
	}

}
