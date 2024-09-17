package com.gooot.annotation;

import static org.assertj.core.api.Assertions.*;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gooot.model.User;

/*
 * @Controller 어노테이션이 설정되어 있는 모든 클래스를 찾아서 출력한다.
 *
 * */
public class ReflectionTest {

	private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

	@Test
	void controllerScan() {
		Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));

		logger.debug("beans : [{}]", beans);

	}

	private static Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
		Reflections reflection = new Reflections("com.gooot");

		Set<Class<?>> beans = new HashSet<>();
		annotations.forEach(annotation -> beans.addAll(reflection.getTypesAnnotatedWith(annotation)));
		return beans;
	}

	@Test
	void showClass() {
		Class<User> clazz = User.class;
		logger.debug(clazz.getName());

		logger.debug("User all declared fields : [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
		logger.debug("User all declared constructors : [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
		logger.debug("User all declared method : [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));

	}


	@Test
	void load() throws ClassNotFoundException {
		// 1.
		Class<User> clazz = User.class;

		// 2.
		User user = new User("serverwizard","홍종완");
		Class<? extends User> clazz2 = user.getClass();

		// 3.
		Class<?> clazz3 = Class.forName("com.gooot.model.User");

		logger.debug("clazz : [{}]", clazz);
		logger.debug("clazz : [{}]", clazz2);
		logger.debug("clazz : [{}]", clazz3);

		assertThat(clazz == clazz2).isTrue();
		assertThat(clazz2 == clazz3).isTrue();
		assertThat(clazz3 == clazz).isTrue();

	}
	
	/*
	@Test
	void controllerScan(){
		Reflections reflection = new Reflections("com.gooot");

		Set<Class<?>> beans = new HashSet<>();
		beans.addAll(reflection.getTypesAnnotatedWith(Controller.class));

		logger.debug("beans : [{}]",beans);



	}

	@Test
	void serviceScan(){
		Reflections reflection = new Reflections("com.gooot");

		Set<Class<?>> beans = new HashSet<>();
		beans.addAll(reflection.getTypesAnnotatedWith(Service.class));

		logger.debug("beans : [{}]",beans);
	}*/
}
