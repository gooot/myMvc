package com.gooot.controller;

import com.gooot.annotation.Controller;
import com.gooot.annotation.Injection;
import com.gooot.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	@Injection
	public UserController(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}
}
