package com.lalit.javaExamples.threads.semaphore;

//ATMUser class. This represents different user wanting to
//withdraw money
public class ATMUser implements Runnable {
	
	private int userNumber;
	private ATMCounters atmCounters;

	public ATMUser(int userNo,ATMCounters atmCntrs) {
		this.userNumber = userNo;
		this.atmCounters = atmCntrs;
	}

	@Override
	public void run() {
		atmCounters.withdrawMoney(this);
	}

	public int getUserNumber() {
		return userNumber;
	}

	
}
