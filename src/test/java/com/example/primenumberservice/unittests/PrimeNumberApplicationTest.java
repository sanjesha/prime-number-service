package com.example.primenumberservice.unittests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimeNumberApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		Integer[] a = {2,3,5,7};
		JSONObject jo = new JSONObject();
		jo.put("limit",10);
		jo.put("primes", a);
		String responseBody = jo.toString();

		this.mockMvc
		.perform(get("/api/v1/primes/10"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().json(responseBody));

	}
}
