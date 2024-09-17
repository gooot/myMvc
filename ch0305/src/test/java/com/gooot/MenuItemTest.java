package com.gooot;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

	@DisplayName("메뉴 아이템 생성")
	@Test
	void create(){


		assertThatCode(()-> new MenuItem("만두",5000))
			.doesNotThrowAnyException();
	}
}
