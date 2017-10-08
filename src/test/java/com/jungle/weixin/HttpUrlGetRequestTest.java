package com.jungle.weixin;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jungle.hdeng.Config;
import com.jungle.lesson.BaseTestCase;

public class HttpUrlGetRequestTest extends BaseTestCase {
	@Autowired
	private Config config;

	@Test
	public void testHttpRequest() throws IOException, URISyntaxException {
		ClientSDK cSdk = new ClientSDK(config.getAppID(), config.getAppsecret());
		HttpUrlGetRequest hur = new HttpUrlGetRequest();
		TokenResult tr = hur.get(cSdk.token().toURI().toString());
		System.out.println(tr);
		assertTrue(tr != null);
	}

}
