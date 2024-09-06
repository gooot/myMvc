package com.gooot;



import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.gooot.calculate.PositiveNumber;


/*
 * 요구사항
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC패턴(Model-View-Controller) 기반으로 구현한다.
 *
 * */

@DisplayName("계산기 테스트")
public class CalculatorTest {



/*
	@DisplayName("더하기 테스트")
	@Test
	public void additionTest(){

		int result = Calculator.calculator(1, "+", 2);

		assertThat(result).isEqualTo(3);

	}

	@DisplayName("뺄셈 테스트")
	@Test
	public void subractionTest(){

		int result = Calculator.calculator(1, "-", 2);

		assertThat(result).isEqualTo(-1);

	}
*/


	@ParameterizedTest
	@MethodSource("calMethod")
	public void primeterizedTest(int operand1, String operator , int operand2, int result){
		int calResult = Calculator.calculator(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
		assertThat(calResult).isEqualTo(result);
	}

	public static Stream<Arguments> calMethod(){
		return Stream.of(
			Arguments.arguments(1,"+",2,3),
			Arguments.arguments(1,"-",2,-1),
			Arguments.arguments(2,"*",3,6),
			Arguments.arguments(4,"/",2,2)
		);

	}



	@DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
	@Test
	void calculateException(){

		assertThatCode(() -> Calculator.calculator(new PositiveNumber(10), "/", new PositiveNumber(0)))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("0 또는 음수를 전달 할 수 없습니다.");

	}



}






