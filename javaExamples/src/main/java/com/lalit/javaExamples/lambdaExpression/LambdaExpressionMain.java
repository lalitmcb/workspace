package com.lalit.javaExamples.lambdaExpression;

import java.util.Comparator;

public class LambdaExpressionMain {
	
public static void main(String[] args){
	
//Let's make two Student object
//One the first roll number and higher marks 
//Other have high roll number but less marks
Student studentOne = new Student(1,80);
Student studentTwo = new Student(20,40);

//Let's compare if studentOne roll number is greater
boolean status = studentOne.isGreaterThan(studentTwo, new Comparator(){

	@Override
	public int compare(Object o1, Object o2) {
		Student studentA = (Student)o1;
		Student studentB = (Student)o2;
		if(studentA.getRollNumber() >= studentB.getRollNumber()){
			return 1;
		}
		return -1;
	}
	
});

System.out.println("StudentOne Roll number is greater than student Two: " + status);

//Now let's compare the marks
 status = studentOne.isGreaterThan(studentTwo, new Comparator(){

		@Override
		public int compare(Object o1, Object o2) {
			Student studentA = (Student)o1;
			Student studentB = (Student)o2;
			if(studentA.getMarks() >= studentB.getMarks()){
				return 1;
			}
			return -1;
		}
		
	});
	
	System.out.println("StudentOne marks is greater than student Two: " + status);

//Now let's use lambda expression for roll number case
status = studentOne.isGreaterThan(studentTwo, (Object o1,Object o2)->{
	Student studentA = (Student)o1;
	Student studentB = (Student)o2;
	if(studentA.getRollNumber() >= studentB.getRollNumber()){
		return 1;
	}
	return -1;
 });
System.out.println("StudentOne Roll number is greater than student Two: " + status);

//Let's use lambda expression for marks case
status = studentOne.isGreaterThan(studentTwo, (Object o1,Object o2)->{
	Student studentA = (Student)o1;
	Student studentB = (Student)o2;
	if(studentA.getMarks() >= studentB.getMarks()){
		return 1;
	}
	return -1;
 });
System.out.println("StudentOne marks is greater than student Two: " + status);
	
}

}
