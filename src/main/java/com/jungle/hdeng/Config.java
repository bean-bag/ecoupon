package com.jungle.hdeng;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {
	
	@Value("${appID}")
	private String appID;

	@Value("${appsecret}")
	private String appsecret;

	public String getAppID() {
		return appID;
	}

	public String getAppsecret() {
		return appsecret;
	}
}
