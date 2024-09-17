package com.gooot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooot.annotation.Controller;
import com.gooot.annotation.RequestMapping;
import com.gooot.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home(HttpServletRequest request , HttpServletResponse response){
		return "home";
	}

}
