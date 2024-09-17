package com.gooot;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
// GET /calculate?operand1=11&operator=*&oerand2=55
public class QueryStringsTest {

	@Test
	void createTest() {
		QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&oerand2=55");

		assertThat(queryStrings).isNotNull();
	}
}
