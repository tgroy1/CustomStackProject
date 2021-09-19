package com.tgroy1.demo.integration;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tgroy1.demo.service.CustomStack;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestStackIntegration {

	@LocalServerPort
	private int port;

	@Autowired
	private CustomStack stack;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testPushItem() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/stack/push?item=1"),
				HttpMethod.POST, entity, String.class);

		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void testPopItem() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		stack.push(2);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/stack/pop"), HttpMethod.GET, entity,
				String.class);

		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void testGetItem() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		stack.push(3);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/stack/get"), HttpMethod.GET, entity,
				String.class);

		assertEquals(200, response.getStatusCodeValue());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
