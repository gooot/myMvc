package com.gooot.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooot.mvc.controller.Controller;
import com.gooot.mvc.view.HandlerAdapter;
import com.gooot.mvc.view.ModelAndView;

public class SimpleControllerHandlerAdapter implements HandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof Controller);
	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object hanlder) throws
		Exception {
		String viewName = ((Controller)hanlder).handleRequest(request,response);
		return new ModelAndView(viewName);
	}
}
