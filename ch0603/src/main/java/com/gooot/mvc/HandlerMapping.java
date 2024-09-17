package com.gooot.mvc;

public interface HandlerMapping {
	Object findHandler(HandlerKey handlerKey);
}
