package com.jungle.weixin;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.github.kevinsawicki.http.HttpRequest;
import com.github.kevinsawicki.http.HttpRequest.HttpRequestException;

public class RequestHelper {
	
	public String read(UriInfo ui) throws HttpRequestException, MalformedURLException, URISyntaxException{
		System.out.println(ui.toURI());
		HttpRequest request = HttpRequest.get(ui.toURI().toURL().toString());
		request.trustAllCerts();
		request.trustAllHosts();
		return request.body();
	}
	
	public static void main(String[] arg){
		boolean _continue = true;
		int i=1;
		while(_continue){
			int num = 63 * i;
			if(num%8==1 && num%5==4 && num%6==3){
				_continue = false;
				System.out.println(num);
			}
			i++;
		}
	}
}
