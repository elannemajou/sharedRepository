package ff4jdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.ff4j.FF4j;
import org.ff4j.core.FlippingStrategy;
import org.junit.Test;

import strategies.OfficeHoursFlippingStrategy;

public class OfficeHoursFlippingStrategyTest {

	// Initialization of target 'ff4j'
	private final FF4j ff4j = new FF4j("ff4j.xml");

	@Test
	public void testCustomStrategy() throws Exception {
		// Given
		assertTrue(ff4j.exist("sayHello"));
		FlippingStrategy fs = ff4j.getFeature("sayHello").getFlippingStrategy();
		assertTrue(fs.getClass() == OfficeHoursFlippingStrategy.class);
		assertEquals("9", fs.getInitParams().get("startDate"));
		
		// When
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		boolean isNowOfficeTime = (hour > 9) && (hour < 18);
		
		// Then
		assertEquals(isNowOfficeTime, ff4j.check("sayHello"));
	}

}
