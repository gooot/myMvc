package com.gooot.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooot.mvc.view.ModelAndView;

public class AnnotationHandlerAdapter implements HandlerAdapter  {
	@Override
	public boolean supports(Object handler) {
		return handler instanceof AnnotationHandler;
	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object hanlder) throws
		Exception {
		String viewName = ((AnnotationHandler) hanlder).handle(request,response);
		return new ModelAndView(viewName);
	}
}
