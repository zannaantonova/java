package ee.bcs.java.demo;

import ee.bcs.java.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MathServiceTest {

	@Autowired
	private MathService mathService;

	@Test
	void mathServiceTest() {
		assertEquals(4, mathService.multiply(2, 2));
	}

}
