package com.gooot;

import java.util.Objects;

public class RequestLine {
	private final String method;
	private final String urlPath;
	// private final String protocal;
	private QueryStrings queryStrings;
	// private String queryString;

	public RequestLine(String requestLine) {
		String[] tokens = requestLine.split(" ");

		String[] urlPathTokens = tokens[1].split("\\?");

		this.method = tokens[0];
		this.urlPath = urlPathTokens[0];
		// this.protocal = tokens[2];

		if(urlPathTokens.length == 2 ){
			this.queryStrings = new QueryStrings(urlPathTokens[1]);
		}



	}

	public RequestLine(String method, String urlPath, String queryString) {
		this.method = method;
		this.urlPath = urlPath;
		this.queryStrings = new QueryStrings(queryString);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RequestLine that = (RequestLine)o;
		return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath)
			// && Objects.equals(protocal, that.protocal)
			&& Objects.equals(queryStrings, that.queryStrings);
	}

	@Override
	public int hashCode() {
		return Objects.hash(method, urlPath,
			// protocal,
			queryStrings);
	}

	public boolean isGetRequest() {
		return "GET".equals(this.method);
	}

	public boolean matchPath(String requstPath) {
		return this.urlPath.equals(requstPath);
	}

	public QueryStrings getQueryStrings() {
		return this.queryStrings;
	}
}
