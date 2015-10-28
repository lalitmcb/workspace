package com.lalit.jssc;

import jssc.SerialPortList;

public class PortListing {

	public static void main(String[] args) {
		
		//Get the list of port names
		String[] ports = SerialPortList.getPortNames();
		
		for(String port: ports){
			System.out.println(port);
		}
	}
}
