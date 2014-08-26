package com.lalit.example.activemq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicConsumer implements Runnable {

	ActiveMQConnectionFactory connectionFactory = null;

	public TopicConsumer(ActiveMQConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	@Override
	public void run() {
		try {
			// First create a connection
			Connection connection = connectionFactory.createConnection();
			connection.start();

			// Now create a Session
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Let's create a topic. If the topic exist,
			// it will return that
			Destination topicDestination = session.createTopic("CLIMATE");

			// Create a MessageProducer from the Session
			// to the Topic or Queue
			MessageConsumer messageConsumer = session
					.createConsumer(topicDestination);

			// Get the message
			Message message = messageConsumer.receive();

			TextMessage textMessage = (TextMessage) message;

			System.out.println(textMessage.getText());

			// Do the cleanup
			session.close();
			connection.close();
		} catch (JMSException jmse) {
			System.out.println("Exception: " + jmse.getMessage());
		}
	}
}
