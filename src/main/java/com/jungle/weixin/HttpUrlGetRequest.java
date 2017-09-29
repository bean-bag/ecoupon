package com.jungle.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpUrlGetRequest {
	public TokenResult get(String requestUrl, String requestMethod) throws IOException {
		URLConnection httpUrlConn = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		try {

			URL url = new URL(requestUrl);
			// http协议传输
			httpUrlConn = /* (HttpURLConnection) */ url.openConnection();

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			// httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();
			// 将返回的输入流转换成字符串
			inputStream = httpUrlConn.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			Gson g = new GsonBuilder().create();
			return g.fromJson(bufferedReader, TokenResult.class);

		} finally {
			bufferedReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			// httpUrlConn.disconnect();
			// httpUrlConn.
		}
	}
}
