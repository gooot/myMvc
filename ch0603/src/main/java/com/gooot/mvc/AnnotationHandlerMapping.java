package com.gooot.mvc;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import com.gooot.mvc.annotation.Controller;
import com.gooot.mvc.annotation.RequestMapping;
import com.gooot.mvc.controller.RequestMethod;

public class AnnotationHandlerMapping implements HandlerMapping {

	private final Object[] basePackge;

	private Map<HandlerKey, AnnotationHandler> handlers = new HashMap<>();

	public AnnotationHandlerMapping(Object... basePackge) {
		this.basePackge = basePackge;
	}

	public void initialize(){
		Reflections reflections = new Reflections(basePackge);

		//homeController
		Set<Class<?>> clazzesWithControllerAnnotation = reflections.getTypesAnnotatedWith(Controller.class);

		clazzesWithControllerAnnotation.forEach(clazz ->
			Arrays.stream(clazz.getDeclaredMethods()).forEach(declaredMethod -> {
				RequestMapping requestMapping = declaredMethod.getDeclaredAnnotation(RequestMapping.class);

				// @RequestMapping(value = "/", method = RequestMethod.GET)
				Arrays.stream(getRequestMathods(requestMapping))
					.forEach(requestMethod -> handlers.put(
						new HandlerKey(requestMethod,requestMapping.value()),new AnnotationHandler(clazz, declaredMethod)
					));
			})
		);

	}

	private RequestMethod[] getRequestMathods(RequestMapping requestMapping) {
		return requestMapping.method();
	}

	@Override
	public Object findHandler(HandlerKey handlerKey) {
		return handlers.get(handlerKey);
	}
}
