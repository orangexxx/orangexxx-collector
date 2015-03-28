package com.orangexxx.home.beans;

public class HomeImage extends ObjectBean {

	public static String HOME_IMAGE_ID = "image_id";
	public static String HOME_IMAGE_HOME_ID = "house_id";
	public static String HOME_IMAGE_URL = "url";
	public static String HOME_IMAGE_INFO = "info";
	
	private int mID;
	private int mHomeID;
	private String mURL;
	private String mInfo;
	
	public HomeImage() {
		this.mHomeID = 0;
		this.mURL = "";
		this.mInfo = "";
	}
	
	private HomeImage(Builder builder) {
		this.mID=builder.mID;
		this.mHomeID=builder.mHomeID;
		this.mURL=builder.mURL;
		this.mInfo=builder.mInfo;
	}
	
	public static class Builder {
		private int mID;
		private int mHomeID;
		private String mURL;
		private String mInfo;
		
		public Builder(){
			
		}
		
		public Builder id(int id) {
			this.mID=id;
			return this;
		}
		
		public Builder homeID(int homeID) {
			this.mHomeID=homeID;
			return this;
		}
		
		public Builder url(String url) {
			this.mURL=url;
			return this;
		}
		
		public Builder info(String info) {
			this.mInfo=info;
			return this;
		}
		
		public HomeImage build() {
			return new HomeImage(this);
		}
	}
	
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public int getmHomeID() {
		return mHomeID;
	}
	public void setmHomeID(int mHomeID) {
		this.mHomeID = mHomeID;
	}
	public String getmURL() {
		return mURL;
	}
	public void setmURL(String mURL) {
		this.mURL = mURL;
	}
	public String getmInfo() {
		return mInfo;
	}
	public void setmInfo(String mInfo) {
		this.mInfo = mInfo;
	}
	
	
	
}
