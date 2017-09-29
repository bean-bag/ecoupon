package com.jungle.weixin;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.kevinsawicki.http.HttpRequest.HttpRequestException;
import com.jungle.lesson.BaseTestCase;

public class RequestHelperTest extends BaseTestCase {
	@Autowired
	private com.jungle.hdeng.Config config;

	@Test
	public final void testRead() throws HttpRequestException, MalformedURLException, URISyntaxException {

		ClientSDK cSdk = new ClientSDK(config.getAppID(), config.getAppsecret());
		RequestHelper rh = new RequestHelper();
		String token = rh.read(cSdk.token());
		System.out.println(token);
		assertTrue(token.length() > 0);
	}

}
