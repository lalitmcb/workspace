package com.lalit.javaExamples.reflection;


public class ClassToReflect {
	
	//No arg constructor
	public ClassToReflect(){
		System.out.println("No argument Constructor");
	}
	
	//Constructor with argument
	public ClassToReflect(String arg){
		privateVariable = arg;
		System.out.println("Argument Constructor woth argument " + arg); 
	}
	
	private String privateVariable;
	
	public String publicVariable;
	
	private void privateMethod(){
		System.out.println("Inside Private Method");
	}
	
	public void publicMethod(){
		System.out.println("Inside Public Method");
	}
	
}
