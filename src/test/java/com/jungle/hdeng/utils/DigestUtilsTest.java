package com.jungle.hdeng.utils;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class DigestUtilsTest {

	@Test
	public void testSha1HexString() {
		String data = "1111sfsfsfdsf中文d";

		String sha1 = com.jungle.hdeng.utils.DigestUtils.sha1Hex(data);
		System.out.println(sha1);
		String digest = DigestUtils.shaHex(data);
		System.out.println(digest);
		assertEquals(sha1, digest);
		// fail("Not yet implemented");
	}

}
