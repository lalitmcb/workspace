package com.lalit.javaExamples.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyBehaviorHandler implements InvocationHandler {

	/**
	 * This method will be called whenever the method on interface is called.
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Entered into proxy method");
		System.out.println("Class of proxy is: " + proxy.getClass().toString());
		System.out.println("Method invoked is: " + method.getName());
		
		for(Object obj:args){
			System.out.println("Argument is of type: " + obj.getClass().toString());
		}
		return null;
	}
}
