package com.lalit.example.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQMain {

	public static void main(String[] args) throws JMSException {
		// Create the connection factory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");

		// Create the consumer. It will wait to listen to the Topic
		Thread topicConsumerThread = new Thread(new TopicConsumer(
				connectionFactory));
		topicConsumerThread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Create a message. As soon as the message is published on the Topic,
		// it will be consumed by the consumer
		Thread topicProducerThread = new Thread(new TopicProducer(
				connectionFactory));
		topicProducerThread.start();
		
	}

}
