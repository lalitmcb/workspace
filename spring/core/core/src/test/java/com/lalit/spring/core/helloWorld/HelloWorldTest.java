package com.lalit.spring.core.helloWorld;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	@Test
	public void test() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext(new String[] {"application-context.xml"});	
		
		HelloWorld helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);
		
		assertNotNull(helloWorld);
		assertEquals("Hello World", helloWorld.getMessage());
	
	}

}
