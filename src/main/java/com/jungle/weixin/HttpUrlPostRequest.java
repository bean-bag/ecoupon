package com.jungle.weixin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpUrlPostRequest {

	public BaseResult post(String requestUrl) throws IOException {
		String ACCESS_TOKEN = "C-R56KhgyhraDooaUVplxSFEEAL8nmHlr8lJw-g9otW_zYivZRwOuFcUIbIPU7aCRI-ANibOJcRHUVdBpEEt5KJHOg4B-8a1uno4BJ6fKOpvPBKzpeIqks1sDoCPCgkWXWXeAFAGFG";

		requestUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + ACCESS_TOKEN;

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
			OutputStreamWriter osw = new OutputStreamWriter(httpUrlConn.getOutputStream(), "utf-8");
			osw.write("{\"button\": [{\"type\": \"click\",\"name\": \"卡券\",\"key\": \"V1001_TODAY_MUSIC\"}]}");
			osw.flush();
			osw.close();
			// 将返回的输入流转换成字符串
			inputStream = httpUrlConn.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			Gson g = new GsonBuilder().create();
			return g.fromJson(bufferedReader, BaseResult.class);

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
