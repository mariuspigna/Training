package com.example.training;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class TrainingApplicationTests {
	NumberTest numberTest = new NumberTest();
	@Test
	void additionNumber() {
		int a = 13, b = 15;
		int result = numberTest.additionNumber(a,b);
		Assertions.assertThat(result).isEqualTo(28);
	}


}
	class NumberTest{
		Integer additionNumber(int a, int b) {
		return a+b;
		}
}
