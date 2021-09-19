package com.tgroy1.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.tgroy1.demo.controller.StackController;

@SpringBootTest
class StackProjectApplicationTests {
	
	@InjectMocks
	private StackController stackController;
	
	@Test
	void contextLoads() {
		assertThat(stackController).isNotNull();
	}

}
