package com.gooot.calculate;

import java.util.List;

public class Calculator {

	private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AddithionOperator(),new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

	public static int calculator(PositiveNumber operand1 , String operator , PositiveNumber operand2) {
		return arithmeticOperators.stream()
			.filter(arithmeticOperators->arithmeticOperators.supports(operator))
			.map(arithmeticOperators-> arithmeticOperators.calculate(operand1,operand2))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
	}

/*
	public static int calculator(int operand1, String operator, int operand2) {


		return ArithmeticOperator.calculate(operand1, operator, operand2);

		// if (operator.equals("+")) {
		// 	return operand1 + operand2;
		// }
		//
		// if (operator.equals("-")) {
		// 	return operand1 - operand2;
		// }
		//
		// return 0;

	}*/

}








