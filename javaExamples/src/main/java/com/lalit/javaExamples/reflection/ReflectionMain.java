package com.lalit.javaExamples.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionMain {
	
public static void main(String[] args){
		
//Getting the class 
Class classToReflect = ClassToReflect.class;
System.out.println("Class to Reflect: " + 
             classToReflect.getSimpleName());

//Get the constructor
Constructor[] constructors = 
		   classToReflect.getConstructors();
for(Constructor c: constructors){
	System.out.println("Constructor: " + c.getName());
	Parameter[] parameters = c.getParameters();
	for(Parameter p: parameters){
		System.out.println("Parameter: " + p.getName());
	}
}

//Creating an object using argument constructor
ClassToReflect objectOfClass = null;
try {
	Constructor constructorWithArgument = 
		classToReflect.getConstructor(String.class);
	objectOfClass = 
	    (ClassToReflect)constructorWithArgument.newInstance("Argument");
} catch (Exception e) {
	//I am handling generic exception. However you might want to
	//handle fine grained exception
	e.printStackTrace();
} 

//Get the variables. 
//Modifiers tell about the type of variable. In our case the modifier are
//PUBLIC -1
//PRIVATE - 2
//For details about modifiers see javadoc of Modifier. Modifier values 
//represent bit positions so that has to be decoded from that perspective.	
//Calling getFields method will only return the public fields
Field[] fields = classToReflect.getDeclaredFields();

//Print fields list
for(Field f: fields){
	System.out.println("Field: " + f.getName() +
			", Type: " + f.getType() + 
			", Modifier: " + f.getModifiers() );
}

//For private variable we can get the value of the variable by making an 
//object
try {
	//Get the private field of object we constructed above
	Field privateVariableField = classToReflect.getDeclaredField("privateVariable");
	
	//To access the value, set accessible needs to be set true. Not a good 
	//idea as this breaks the object oriented concepts
	//Try commenting this and you will see an exception.
	privateVariableField.setAccessible(true);
	
	System.out.println("Value: " + privateVariableField.get(objectOfClass));
} catch (Exception e) {
	System.out.println("Exception: " + e.getMessage());
}

//For methods. We will see only public method. getMethods will return
//all the methods from super class also
Method[] methods = classToReflect.getDeclaredMethods();

//Print methods list
for(Method m: methods){
	System.out.println("Method: " + m.getName() + 
			           ", Return Type: " + m.getReturnType() +
			           ", Modifier: " + m.getModifiers());
	
	
	Parameter[] parameters = m.getParameters();
	for(Parameter p: parameters){
		System.out.println("Parameter Type: " + p.getType());		
	}
}

//Invoking public method
try {
	Method publicMethodToInvoke = classToReflect.getDeclaredMethod("publicMethod", null);
	publicMethodToInvoke.invoke(objectOfClass,null);
} catch (Exception e) {
	e.printStackTrace();
} 

//Invoking private method
try {
	Method privateMethodToInvoke = classToReflect.getDeclaredMethod("privateMethod", null);
	
	//Need to set the accessibility as true
	//Not a good idea
	privateMethodToInvoke.setAccessible(true);
	
	privateMethodToInvoke.invoke(objectOfClass,null);
} catch (Exception e) {
	e.printStackTrace();
} 
}

}
