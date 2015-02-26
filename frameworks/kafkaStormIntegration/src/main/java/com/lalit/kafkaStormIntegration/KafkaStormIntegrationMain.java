package com.lalit.kafkaStormIntegration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lalit.kafkaStormIntegration.storm.KafkaStormIntegration;

public class KafkaStormIntegrationMain {

	public static void main(String[] args) {

		System.out.println("Type q anytime to stop the program");
		KafkaStormIntegration kafkaStormIntegrationJob = new KafkaStormIntegration();
		Thread stormTopologyThread = new Thread(kafkaStormIntegrationJob);
		stormTopologyThread.start();

		String message = null;
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				message = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (message.equals("q")) {				
				break;
			}			
		}
		System.out.println("Stopping cluster");
		kafkaStormIntegrationJob.stop();
		stormTopologyThread.interrupt();
		System.out.println("Finishing program");

	}

}
