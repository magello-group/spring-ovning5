package se.r2m.spring.ovning5.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=BeanDefinition.SCOPE_PROTOTYPE)
public class SayTime implements InitializingBean {
	
	private String time;
	private GeneralMethods generalMethods;

	@Autowired
	public SayTime(GeneralMethods generalMethods) {
		this.generalMethods = generalMethods;
	}
	
	public String formattedTime() {
		return time;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		time = new SimpleDateFormat(generalMethods.dateFormat()).format(new Date());
	}
}
