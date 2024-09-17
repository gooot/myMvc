package com.gooot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
// GET /calculate?operand1=11&operator=*&oerand2=55
public class QueryStringTest {

	@Test
	void createTest(){
		QueryString queryString = new QueryString("operand1","11");

		assertThat(queryString).isNotNull();
	}
}
