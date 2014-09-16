package com.lalit.javaExamples.dynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyMain {

	public static void main(String[] args) {

		// Create an instance of handler class
		ProxyBehaviorHandler proxyBehaviorHandler = new ProxyBehaviorHandler();

		// Create a dynamic proxy
		InterfaceToProxy interFaceToProxy = (InterfaceToProxy) Proxy
				.newProxyInstance(InterfaceToProxy.class.getClassLoader(),
						new Class[] { InterfaceToProxy.class },
						proxyBehaviorHandler);

		// Call the method on the proxy. This will result in calling the method
		// implemented in handler
		interFaceToProxy.callMe("Hello", 2);

		// The proxy instance will be true for instance of operator
		System.out.println(interFaceToProxy instanceof InterfaceToProxy);

	}

}
