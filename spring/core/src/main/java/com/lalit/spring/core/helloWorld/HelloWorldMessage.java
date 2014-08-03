package com.lalit.spring.core.helloWorld;

import org.springframework.stereotype.Component;

@Component("helloWorldMessage")
public class HelloWorldMessage implements Message{

	@Override
	public String getMessage() {
		return "Hello World";
	}

}
