package com.jungle.weixin;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class UriInfo {

	private String protocol = "http";
	private String host;
	private int port = -1;
	// private String authority;
	private String userInfo;
	private String path;
	private String query;
	private String fragment;

	private Map<String, String> params = new HashMap<>();

	public URI toURI() throws URISyntaxException {

		if (query == null && params.size() > 0) {
			query = toQuery();
		}

		return new URI(protocol, userInfo, host, port, path, query, fragment);
	}

	private String toQuery() {
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<String, String>> iter = params.entrySet().iterator();
		if (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			sb.append(entry.getKey());
			sb.append('=');
			sb.append(entry.getValue());
		}
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			sb.append('&');
			sb.append(entry.getKey());
			sb.append('=');
			sb.append(entry.getValue());
		}
		return sb.toString();
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public UriInfo put(String key, String value) {
		this.params.put(key, value);
		return this;
	}

	public void setFragment(String fragment) {
		this.fragment = fragment;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}
