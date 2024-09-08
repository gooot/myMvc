import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RequestLineTest {

	@Test
	void createTest(){
		RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator=*&oerand2=55 HTTP/1.1");

		assertThat(requestLine).isNotNull();

	}
}
