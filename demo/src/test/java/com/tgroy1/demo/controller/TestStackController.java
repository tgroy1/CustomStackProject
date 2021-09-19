package com.tgroy1.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tgroy1.demo.service.CustomStack;

@RunWith(PowerMockRunner.class)
public class TestStackController {

	@InjectMocks
	private StackController stackController;

	@Mock
	private CustomStack stack;

	@Test
	public void testPushItem() {

		try {
			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

			doNothing().when(stack).push(Mockito.anyInt());

			ResponseEntity<Object> response = stackController.push(1);

			assertThat(response.getBody()).isEqualTo(1);
		} catch (Exception e) {
			fail("testPushItem failed ");
		}
	}

	@Test
	public void testPopItem() {

		try {
			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

			when(stack.pop()).thenReturn(1);

			ResponseEntity<Object> response = stackController.pop();

			assertThat(response.getBody()).isEqualTo(1);
		} catch (Exception e) {
			fail("testPopItem failed ");
		}
	}

	@Test
	public void testGetItem() {

		try {
			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

			when(stack.get()).thenReturn(1);

			ResponseEntity<Object> response = stackController.get();

			assertThat(response.getBody()).isEqualTo(1);
		} catch (Exception e) {
			fail("testGetItem failed ");
		}
	}
}
