package com.example.primenumberservice.componenttest;

import com.example.primenumberservice.PrimeNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ComponentTest {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void serviceShouldReturnPrimesTillLimit() throws Exception {
		int limit = 10;
		Integer[] a = {2,3,5,7};
		Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/primes/" + limit,
				PrimeNumber.class)).isEqualTo(new PrimeNumber(limit, a));
	}
}
