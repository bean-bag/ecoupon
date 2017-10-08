package com.jungle.lesson;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jungle.hdeng.Config;

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
		// String access_token =
		// "1wgX4h48CqkPm3eFwirKK2gtaa_D_bJByCFceDQQDLd4WqKk06j68PzdOwUJAx213M39MkgKqBF41RX0WtG70Q16Pa_DZ-8mbUnKuxxEUarpt9CcHW228lJIE9DIG8APXHPjAEAOYG";
		// String url0 =
		// "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=1wgX4h48CqkPm3eFwirKK2gtaa_D_bJByCFceDQQDLd4WqKk06j68PzdOwUJAx213M39MkgKqBF41RX0WtG70Q16Pa_DZ-8mbUnKuxxEUarpt9CcHW228lJIE9DIG8APXHPjAEAOYG";
		// String url1 =
		// "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxc2500b2ff1e9393d&secret=c44310818f64ff1d16b43de6fdc972e8";

	}
}
