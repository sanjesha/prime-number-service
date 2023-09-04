package com.example.primenumberservice.unittests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.primenumberservice.PrimeNumber;
import com.example.primenumberservice.PrimeNumberController;
import com.example.primenumberservice.PrimeNumberService;
import com.example.primenumberservice.algorithms.Algorithm;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PrimeNumberController.class)
public class PrimeNumberControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PrimeNumberService service;

	@Test
	public void controllerShouldReturnA200Response() throws Exception {
		Integer[] a = {2,3,5,7};
		JSONObject jo = new JSONObject();
		jo.put("limit",10);
		jo.put("primes", a);
		String responseBody = jo.toString();

		PrimeNumber primeNumber = new PrimeNumber(10, a);


		when(service.getPrimes(10, Algorithm.DEFAULT)).thenReturn(primeNumber);
		this.mockMvc
				.perform(get("/api/v1/primes/10"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(responseBody));
	}

	@Test
	public void controllerShouldReturnA400ResponseForInvalidLimit() throws Exception {
		this.mockMvc
				.perform(get("/api/v1/primes/abc"))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	public void controllerShouldReturnA400ResponseForInvalidAlgorithm() throws Exception {
		this.mockMvc
				.perform(get("/api/v1/primes/10?algorithm=abc"))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}


}
