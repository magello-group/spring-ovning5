package se.r2m.spring.ovning5.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=BeanDefinition.SCOPE_PROTOTYPE)
public class GeneralMethods {
	
	private SayTime sayTime;

	@Autowired
	public GeneralMethods(SayTime sayTime) {
		this.sayTime = sayTime;
	}

	public String dateFormat() {
		return "yyyy-MM-dd HH:mm:ss";
	}
	
	public String greetingString() {
		return "Hello, time is now " + sayTime.formattedTime();
	}
	
}
