package com.orangexxx.home.beans;

public class HomeInfo extends ObjectBean {

	
	public static String HOME_INFO_ID = "house_id";
	public static String HOME_INFO_TITLE = "title";
	public static String HOME_INFO_SPACE = "space";
	public static String HOME_INFO_STYLE = "style";
	public static String HOME_INFO_PART = "part";
	public static String HOME_INFO_SHAPE = "shape";
	public static String HOME_INFO_STUFF = "stuff";
	public static String HOME_INFO_DESIGNER = "designer";
	public static String HOME_INFO_BUDGET = "budget";
	public static String HOME_INFO_SIZE = "size";
	public static String HOME_INFO_FEEL = "feel";
	public static String HOME_INFO_COLOR = "color";
	public static String HOME_INFO_URL = "url";
	
	private int mID;
	private String mTitle;
	private String mSpace;
	private String mStyle;
	private String mPart;
	private String mShape;
	private String mStuff;
	private String mDesigner;
	private String mBudget;
	private String mSize;
	private String mFeel;
	private String mColor;
	private String mURL;
	
	
	public HomeInfo() {
		this.mTitle = "";
		this.mSpace = "";
		this.mStyle = "";
		this.mPart = "";
		this.mShape = "";
		this.mStuff = "";
		this.mDesigner = "";
		this.mBudget = "";
		this.mSize = "";
		this.mFeel = "";
		this.mColor = "";
		this.mURL = "";
	}
	
	private HomeInfo(Builder builder) {
		this.mID=builder.mID;
		this.mTitle=builder.mTitle;
		this.mSpace=builder.mSpace;
		this.mStyle=builder.mStyle;
		this.mPart=builder.mPart;
		this.mShape=builder.mShape;
		this.mStuff=builder.mStuff;
		this.mDesigner=builder.mDesigner;
		this.mBudget=builder.mBudget;
		this.mSize=builder.mSize;
		this.mFeel=builder.mFeel;
		this.mColor=builder.mColor;
		this.mURL=builder.mURL;
	}
	
	public static class Builder {
		private int mID=0;
		private String mTitle="";
		private String mSpace="";
		private String mStyle="";
		private String mPart="";
		private String mShape="";
		private String mStuff="";
		private String mDesigner="";
		private String mBudget="";
		private String mSize="";
		private String mFeel="";
		private String mColor="";
		private String mURL="";
		
		public Builder() {}
		
		
		public Builder id(int id) {
			this.mID=id;
			return this;
		}
		
		public Builder title(String title) {
			this.mTitle=title;
			return this;
		}
		
		public Builder space(String space) {
			this.mSpace=space;
			return this;
		}
		
		public Builder style(String style) {
			this.mStyle=style;	
			return this;	
		}
		
		public Builder part(String part) {
			this.mPart=part;
			return this;
		}
		
		public Builder shape(String shape) {
			this.mShape=shape;
			return this;
		}
		
		public Builder stuff(String stuff) {
			this.mStuff=stuff;
			return this;
		}
		
		public Builder designer(String designer) {
			this.mDesigner=designer;
			return this;
		}
		
		public Builder budget(String budget) {
			this.mBudget=budget;
			return this;
		}
		
		public Builder size(String size) {
			this.mSize=size;
			return this;
		}
		
		public Builder feel(String feel) {
			this.mFeel=feel;
			return this;
		}
		
		public Builder color(String color) {
			this.mColor=color;
			return this;
		}
		
		public Builder url(String url) {
			this.mURL=url;
			return this;
		}
		
		public HomeInfo build() {
			return new HomeInfo(this);
		}
	}
	public int getmID() {
		return mID;
	}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public String getmTitle() {
		return mTitle;
	}
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getmSpace() {
		return mSpace;
	}
	public void setmSpace(String mSpace) {
		this.mSpace = mSpace;
	}
	public String getmStyle() {
		return mStyle;
	}
	public void setmStyle(String mStyle) {
		this.mStyle = mStyle;
	}
	public String getmPart() {
		return mPart;
	}
	public void setmPart(String mPart) {
		this.mPart = mPart;
	}
	public String getmShape() {
		return mShape;
	}
	public void setmShape(String mShape) {
		this.mShape = mShape;
	}
	public String getmStuff() {
		return mStuff;
	}
	public void setmStuff(String mStuff) {
		this.mStuff = mStuff;
	}
	public String getmDesigner() {
		return mDesigner;
	}
	public void setmDesigner(String mDesigner) {
		this.mDesigner = mDesigner;
	}
	public String getmBudget() {
		return mBudget;
	}
	public void setmBudget(String mBudget) {
		this.mBudget = mBudget;
	}
	public String getmSize() {
		return mSize;
	}
	public void setmSize(String mSize) {
		this.mSize = mSize;
	}
	public String getmFeel() {
		return mFeel;
	}
	public void setmFeel(String mFeel) {
		this.mFeel = mFeel;
	}
	public String getmColor() {
		return mColor;
	}
	public void setmColor(String mColor) {
		this.mColor = mColor;
	}
	public String getmURL() {
		return mURL;
	}
	public void setmURL(String mURL) {
		this.mURL = mURL;
	}
	
	
}
