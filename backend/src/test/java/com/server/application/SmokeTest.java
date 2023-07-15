package com.server.application;

import com.server.controller.LivestockController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SmokeTest {

	@Autowired
	private LivestockController livestockController;

	@Test
	void contextLoads() {
		assertThat(livestockController).as("livestock api controller").isNotNull();
	}

}
