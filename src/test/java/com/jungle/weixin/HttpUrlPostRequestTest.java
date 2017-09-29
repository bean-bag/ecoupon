package com.jungle.weixin;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

public class HttpUrlPostRequestTest {

	@Test
	public void testPost() throws IOException {
		HttpUrlPostRequest hr = new HttpUrlPostRequest();
		BaseResult a = hr.post("");
		assertTrue(null != a);
		System.out.println(a.getErrcode());
		System.out.println(a.getErrmsg());
		// fail("Not yet implemented");
	}

}
