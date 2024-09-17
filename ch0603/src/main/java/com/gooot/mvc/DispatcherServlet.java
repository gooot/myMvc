package com.gooot.mvc;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gooot.mvc.controller.Controller;
import com.gooot.mvc.controller.HandlerKey;
import com.gooot.mvc.controller.RequestMethod;
import com.gooot.mvc.view.HandlerAdapter;
import com.gooot.mvc.view.HandlerMapping;
import com.gooot.mvc.view.JspViewResolver;
import com.gooot.mvc.view.ModelAndView;
import com.gooot.mvc.view.View;
import com.gooot.mvc.view.ViewResolver;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);

	private HandlerMapping hm;

	private List<HandlerAdapter> handlerAdapters;

	private List<ViewResolver> viewResolvers;

	@Override
	public void init() throws ServletException {
		RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
		requestMappingHandlerMapping.init();

		hm = requestMappingHandlerMapping;

		handlerAdapters = List.of(new SimpleControllerHandlerAdapter());
		viewResolvers = Collections.singletonList(new JspViewResolver());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.info("DispatcherServlet");
		// super.service(req, resp);



		log.info("[DispatcherServlet] service started.");
		try {
			Object handler = hm.findHandler(new HandlerKey(RequestMethod.valueOf(request.getMethod()),request.getRequestURI()));
			// String viewName = handler.handleRequest(request,response);

			HandlerAdapter handlerAdapter = handlerAdapters.stream()
				.filter(ha -> ha.supports(handler))
				.findFirst()
				.orElseThrow(() -> new ServletException("No adapter for handler [" + handler + "]"));

			ModelAndView modelAndView = handlerAdapter.handle(request,response,handler);

			for(ViewResolver viewResolver : viewResolvers) {
				// View view = viewResolver.resolverView(viewName);
				View view = viewResolver.resolverView(modelAndView.getName());
				view.render(modelAndView.getModel(), request, response);
			}


		} catch (Exception e) {
			log.error("Exception occurred : [{}]", e.getMessage(),e);
		}

	}
}
