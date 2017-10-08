package com.jungle.weixin;

import java.io.IOException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

public class HttpUrlGetRequest {
	public TokenResult get(String requestUrl) throws IOException {

		URL url = new URL(requestUrl);

		ObjectMapper om = new ObjectMapper();
		return om.readValue(url, TokenResult.class);

	}
}
