package com.gooot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.swing.text.Position;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gooot.calculate.Calculator;
import com.gooot.calculate.PositiveNumber;

@WebServlet("/calculate")
public class CalculatorServlet implements Servlet {

	public final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

	private ServletConfig servletConfig;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		log.info("service");
		this.servletConfig = servletConfig;

	}

	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws
		ServletException,
		IOException {

		log.info("service");

		int operand1 = Integer.parseInt(servletRequest.getParameter("operand1"));
		String operator = servletRequest.getParameter("operator");
		int operand2 = Integer.parseInt(servletRequest.getParameter("operand2"));

		int result = Calculator.calculator(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

		PrintWriter writer = servletResponse.getWriter();
		writer.println(result);

	}

	@Override
	public String getServletInfo() {
		return "";
	}

	@Override
	public void destroy() {
		// resource release

	}
}
