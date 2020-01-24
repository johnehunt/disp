package com.jjh.echo;

import javax.xml.ws.Endpoint;

public class Main {

	public static void main(String[] args) {
		String url = "http://localhost:8080/echo";
		Endpoint.publish(url, new Echo());
		System.out.println("Service started @ " + url);
	}

}
