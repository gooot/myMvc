package com.gooot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
// GET /calculate?operand1=11&operator=*&oerand2=55
public class RequestLineTest {

	@Test
	void createTest(){
		RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator=+&operand2=55 HTTP/1.1");

		assertThat(requestLine).isNotNull();
		assertThat(requestLine).isEqualTo(new RequestLine("GET", "/calculate" , "operand1=11&operator=*&operand2=55" ));

	}
}
