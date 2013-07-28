package com.lalit.spring.core.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("helloWorld")
public class HelloWorld {

	@Autowired
	HelloWorldMessage helloWorldMessage;
	
	public String getMessage(){
		return helloWorldMessage.getMessage();
	}
}
