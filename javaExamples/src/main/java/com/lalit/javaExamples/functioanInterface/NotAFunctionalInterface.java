package com.lalit.javaExamples.functioanInterface;


//Uncommenting the functional interface annotaion will give compile error
// "Invalid '@FunctionalInterface' annotation; 
//   NotAFunctionalInterface is not a functional interface"
//@FunctionalInterface
public interface NotAFunctionalInterface {

	public void firstFunction();
	public void secondFunction();
}
