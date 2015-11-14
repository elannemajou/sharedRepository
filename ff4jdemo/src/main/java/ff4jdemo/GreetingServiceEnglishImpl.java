package ff4jdemo;

import org.springframework.stereotype.Component;

@Component("greeting.english")
public class GreetingServiceEnglishImpl implements GreetingService {

	public String sayHello(String name) {
		return "Hello " + name;
	}

}
