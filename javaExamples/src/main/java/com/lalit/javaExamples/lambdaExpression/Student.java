package com.lalit.javaExamples.lambdaExpression;

import java.util.Comparator;

public class Student {
	
	int rollNumber;
	int marks;
	
	public Student(int rollNumberValue, int marksValue){
		rollNumber = rollNumberValue;
		marks = marksValue;		
	}	
	
	public int getRollNumber() {
		return rollNumber;
	}

	public int getMarks() {
		return marks;
	}

	//Pass a comparator interface and this will be defined as per context.
	public boolean isGreaterThan(Student otherStudent, Comparator comparator) {
		int returnValue = comparator.compare(this, otherStudent);
		if(returnValue >= 0){
			return true;
		}else{
			return false;
		}
	}


}
