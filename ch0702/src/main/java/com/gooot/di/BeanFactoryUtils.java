package com.gooot.di;

import java.lang.reflect.Constructor;
import java.util.Set;

import org.reflections.ReflectionUtils;

import com.gooot.annotation.Injection;

public class BeanFactoryUtils {

	public static Constructor<?> getInjectedConstructor(Class<?> clazz) {
		Set<Constructor> injectedConstructors = ReflectionUtils.getAllConstructors(clazz,
			ReflectionUtils.withAnnotation(Injection.class));
		if (injectedConstructors.isEmpty()) {
			return null;
		}
		return injectedConstructors.iterator().next();
	}


}
