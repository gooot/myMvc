package com.gooot;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gooot.calculate.Calculator;
import com.gooot.calculate.PositiveNumber;

@WebServlet("/calculatorHttpServlet")
public class CalculatorHttpServlet extends HttpServlet {

	private static final Logger log = LoggerFactory.getLogger(CalculatorHttpServlet.class);

	@Override
	protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
		log.info("service");

		int operand1 = Integer.parseInt(servletRequest.getParameter("operand1"));
		String operator = servletRequest.getParameter("operator");
		int operand2 = Integer.parseInt(servletRequest.getParameter("operand2"));

		int result = Calculator.calculator(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

		PrintWriter writer = servletResponse.getWriter();
		writer.println(result);

	}

}
