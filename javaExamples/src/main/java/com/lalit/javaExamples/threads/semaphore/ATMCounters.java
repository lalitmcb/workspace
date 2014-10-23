package com.lalit.javaExamples.threads.semaphore;

import java.util.concurrent.Semaphore;
/**
 * ATMCounters is the number of ATM machines available.
 * The number of counters is passed as an argument to constructor
 * @author Lalit
 *
 */
public class ATMCounters {
	
	//Semaphore is the lock 
	private Semaphore semapahore;
	
	public ATMCounters(int numberOfCounters){
		//Number of resources available is passed as argument
		semapahore = new Semaphore(numberOfCounters);
	}

	public void withdrawMoney(ATMUser atmUser){
		try{
			//Acquire the thread. It will acquire only if 
			//resources are available			
			semapahore.acquire();
			
			System.out.println("User: " + atmUser.getUserNumber() + " withdrawing money");
			
			//Put a random sleep
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.out.println("User: " + atmUser.getUserNumber() + " money withdrawn");
			System.out.println("Sempahore resource count :" + semapahore.availablePermits());
			
			//Make sure to release the semaphore
			semapahore.release();
		}
	}
}
