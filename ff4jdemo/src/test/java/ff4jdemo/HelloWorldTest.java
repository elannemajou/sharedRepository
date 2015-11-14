package ff4jdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.ff4j.FF4j;
import org.ff4j.exception.FeatureNotFoundException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldTest {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(HelloWorldTest.class);

	@Test
	public void myFirstFF4JTest() {
		FF4j ff4j = new FF4j("ff4j.xml");
		assertEquals(2, ff4j.getFeatures().size());
		assertTrue(ff4j.exist("sayHello"));
		assertTrue(ff4j.check("sayHello"));
		if (ff4j.check("sayHello")) {
			LOGGER.info("Hello World !");
		} else {
			fail();
		}
	}

	@Test
	public void autoCreateFeatureEnableTest() {
		// Default : store = inMemory, load features from ff4j.xml file
		FF4j ff4j = new FF4j("ff4j.xml");
		try {
			ff4j.check("autoCreatedFeature");
			fail(); // error is Expected here
		} catch (FeatureNotFoundException fnfe) {
			LOGGER.info("Standard behaviour");
		}
		// Change default behavior
		ff4j.autoCreate(true);
		if (!ff4j.check("autoCreatedFeature")) {
			LOGGER.info("Not available but code won't failed, feature created");
			assertTrue(ff4j.exist("autoCreatedFeature"));
			assertFalse(ff4j.check("autoCreatedFeature"));
		} else {
			fail();
		}
	}

	@Test
	public void createFeatureDynamically() {
		// Initialize with empty store
		FF4j ff4j = new FF4j();
		// Dynamically register new features
		ff4j.create("f1").enable("f1");
		// Testing
		assertTrue(ff4j.exist("f1"));
		assertTrue(ff4j.check("f1"));
	}
}
