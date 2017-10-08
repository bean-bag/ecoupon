package com.jungle.weixin.buttons;

public class ActionButton extends Button {
	private String type;// ": "click",
	private String key;// ": "V1001_TODAY_MUSIC",

	private String url;

	protected void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

}
