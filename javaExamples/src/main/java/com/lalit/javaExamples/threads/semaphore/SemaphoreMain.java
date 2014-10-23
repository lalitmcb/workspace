package com.lalit.javaExamples.threads.semaphore;

public class SemaphoreMain {

	public static void main(String[] args) {
		
		//Let's have three atm counters
		ATMCounters atmCounters = new ATMCounters(3);
		
		//Create 10 users and ask them to withdraw money
		for(int i =0 ; i < 10; i++){
			Thread thread = new Thread(new ATMUser(i,atmCounters));
			thread.start();
		}

	}

}
