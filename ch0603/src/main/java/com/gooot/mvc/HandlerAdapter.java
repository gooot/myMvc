package com.gooot.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooot.mvc.view.ModelAndView;

public interface HandlerAdapter {

	boolean supports(Object handler);

	ModelAndView handle(HttpServletRequest request , HttpServletResponse response , Object hanlder) throws Exception;
}
