package com.gooot.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gooot.mvc.model.User;
import com.gooot.mvc.repository.UserRepository;

public class UserCreateController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserRepository.save(new User(request.getParameter("userId"),request.getParameter("name")));
		return "redirect:/users";
	}
}
