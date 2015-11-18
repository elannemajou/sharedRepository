package ff4jdemo;

import org.ff4j.FF4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:*applicationContext.xml")
public class FeatureFlippingThoughAopTest {

	@Autowired
	private FF4j ff4j;

	@Autowired
	@Qualifier("greeting.english")
	private GreetingService greeting;

	@Test
	public void testAOP() {
		Assert.assertTrue(greeting.sayHello("CLU").startsWith("Hello"));
		ff4j.enable("language-french");
		Assert.assertTrue(greeting.sayHello("CLU").startsWith("Bonjour"));
	}

}
