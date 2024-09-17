package com.gooot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CorseTest {


	@DisplayName("과목을 생성한다")
	@Test
	void createTest() {

		assertThatCode(()->new Course("OOP",3,"A+"))
			.doesNotThrowAnyException();
	}
}
