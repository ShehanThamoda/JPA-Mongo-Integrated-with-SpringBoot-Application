
package lk.dialog.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestApplicationTests {

	@Test
	void contextLoads() {
		int id = 2;
		int id2 = 2;
		Assertions.assertEquals(id,id2);
	}

}
