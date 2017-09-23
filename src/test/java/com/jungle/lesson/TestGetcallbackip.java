package com.jungle.lesson;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestGetcallbackip extends BaseTestCase {
	private final static Logger log = LoggerFactory.getLogger(TestGetcallbackip.class);

	@Autowired
	private Config config;
	
	@Value("${appsecret}")
	private String appsecret;
	
	@Test
	public final void test() {

		log.info(config.getAppID());
		log.info(appsecret);
		String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
		
	}

}
