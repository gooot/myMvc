package com.gooot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gooot.calculate.Calculator;
import com.gooot.calculate.PositiveNumber;

@WebServlet("/calculateGeneric")
public class CalculatorGenericServlet extends GenericServlet {

	public final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);


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
}
