package com.gooot.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooot.mvc.annotation.RequestMapping;
import com.gooot.mvc.annotation.Controller;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "home";
	}
}
