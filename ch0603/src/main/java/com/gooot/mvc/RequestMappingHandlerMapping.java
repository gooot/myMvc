package com.gooot.mvc;

import java.util.HashMap;
import java.util.Map;

import com.gooot.mvc.controller.Controller;
import com.gooot.mvc.controller.ForwardController;
import com.gooot.mvc.controller.HandlerKey;
import com.gooot.mvc.controller.HomeController;
import com.gooot.mvc.controller.RequestMethod;
import com.gooot.mvc.controller.UserCreateController;
import com.gooot.mvc.controller.UserListController;

public class RequestMappingHandlerMapping {

	private Map<HandlerKey, Controller> mappings = new HashMap<>();

	void init(){
		mappings.put(new HandlerKey(RequestMethod.GET,"/"), new HomeController());
		mappings.put(new HandlerKey(RequestMethod.GET,"/users"), new UserListController());
		mappings.put(new HandlerKey(RequestMethod.POST,"/users"), new UserCreateController());
		mappings.put(new HandlerKey(RequestMethod.GET,"/user/form"), new ForwardController("/user/form"));
	}

	public Controller findHandler(HandlerKey handlerKey){
		return mappings.get(handlerKey);
	}
}
