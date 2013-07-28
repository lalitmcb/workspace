package com.lalit.spring.core.helloWorld;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloWorldTest {

	@Test
	public void test() {

		// Let's create the Spring container
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "application-context.xml" });

		// Fetch the helloWorld bean
		HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
		
		//Let's check if the bean is not null and returns the string
		assertNotNull(helloWorld);
		assertSame("HelloWorld", helloWorld.getMessage());
	}

}
