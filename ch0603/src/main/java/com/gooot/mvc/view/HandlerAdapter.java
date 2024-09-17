package com.gooot.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HandlerAdapter {

	boolean supports(Object handler);

	ModelAndView handle(HttpServletRequest request , HttpServletResponse response , Object hanlder) throws Exception;
}
