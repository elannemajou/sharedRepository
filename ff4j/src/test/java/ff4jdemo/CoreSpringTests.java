package ff4jdemo;

import static org.junit.Assert.fail;

import org.ff4j.FF4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:*applicationContext.xml"})
public class CoreSpringTests {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(CoreSpringTests.class);
	
	@Autowired
	private FF4j ff4j;
	
	@Test
	public void testWithSpring() {
		// Test value at runtime
		if (ff4j.check("sayHello")) {
			// Feature ok !
			LOGGER.info("Hello World !");
		} else {
			fail();
		}
	}

}
