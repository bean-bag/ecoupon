package com.jungle.weixin;

import java.net.URISyntaxException;

public class ClientSDK {

	private String appID;

	private String appsecret;

	private String protocol = "https";
	private String host = "api.weixin.qq.com";

	public ClientSDK(String appID, String appsecret) {
		this.appID = appID;
		this.appsecret = appsecret;
	}

	private UriInfo createUriInfo(){
		UriInfo u = new UriInfo();
		u.setProtocol(protocol);
		u.setHost(host);
		return u;
	}
	/**
	 * 通过app标识，获取会话token
	 * 
	 * @return
	 * @throws URISyntaxException
	 * <br>https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	 */
	public UriInfo token() throws URISyntaxException {
		UriInfo u = createUriInfo();
		
		u.setPath("/cgi-bin/token");

		u.put("grant_type", "client_credential");
		u.put("appid", appID);
		u.put("secret", appsecret);

		return u;
	}

	/**
	 * 获取服务器IP地址
	 * @param access_token
	 * @return
	 * @throws URISyntaxException
	 * <br>https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
	 */
	public UriInfo getcallbackip(String access_token) throws URISyntaxException {
		UriInfo u = createUriInfo();
		
		u.setPath("/cgi-bin/getcallbackip");

		u.put("access_token", access_token);

		return u;
	}

	/**
	 * 获取单个用户基本信息
	 * @param access_token
	 * @param openID
	 * @param lang
	 * @return
	 * @throws URISyntaxException
	 * <br>https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	 */
	public UriInfo uerInfo(String access_token, String openID, String lang) throws URISyntaxException {
		UriInfo u = createUriInfo();
		
		u.setPath("/cgi-bin/user/info");

		u.put("access_token", access_token);
		u.put("openid", openID);
		u.put("lang", lang);

		return u;
	}

}
