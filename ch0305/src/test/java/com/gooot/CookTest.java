package com.gooot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookTest {



	@DisplayName("요리 생성")
	@Test
	void createTest(){


		assertThatCode(()-> new Cook("만두",5000))
			.doesNotThrowAnyException();

	}
}
