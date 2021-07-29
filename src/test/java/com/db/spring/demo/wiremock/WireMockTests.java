package com.db.spring.demo.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.junit.Rule;
import org.junit.jupiter.api.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.*;

public class WireMockTests {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8085);

	@Rule
	WireMockServer wireMockServer = new WireMockServer(8085);

	@Test
	public void exampleTest() {
		System.out.println("Start");

		wireMockServer.start();

		stubFor(get("/Employee/101").willReturn(ok()));
		
		wireMockServer.stop();

	}

}
