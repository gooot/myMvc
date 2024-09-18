package com.gooot.di;

import static org.assertj.core.api.Assertions.*;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import com.gooot.annotation.Controller;
import com.gooot.annotation.Service;
import com.gooot.controller.UserController;

class BeanFactoryTest {


	private Reflections reflections;
	private BeanFactory beanFactory;
	
	@BeforeEach
	@SuppressWarnings("unchecked")
	public void setUp(){
		
		reflections = new Reflections("com.gooot");
		Set<Class<?>> preInstantiatedClazz = getTypesAnnotatedWith(Controller.class, Service.class);
		beanFactory = new BeanFactory(preInstantiatedClazz);
		
	}

	private Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation>... annotations) {
		Set<Class<?>> beans = new HashSet<>();
		for(Class<? extends Annotation> annotation : annotations){
			beans.addAll(reflections.getTypesAnnotatedWith(annotation));
		}


		return beans;
	}


	@Test
	void diTest(){
		UserController userController = beanFactory.getBean(UserController.class);

		assertThat(userController).isNotNull();
		assertThat(userController.getUserService()).isNotNull();

	}

}