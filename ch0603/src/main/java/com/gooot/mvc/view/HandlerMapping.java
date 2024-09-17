package com.gooot.mvc.view;

import com.gooot.mvc.controller.Controller;
import com.gooot.mvc.controller.HandlerKey;

public interface HandlerMapping {
	Object findHandler(HandlerKey handlerKey);
}
