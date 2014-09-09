package com.lalit.exchangeWebServiceIntegration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.Properties;

import microsoft.exchange.webservices.data.EmailMessage;
import microsoft.exchange.webservices.data.ExchangeCredentials;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.ExchangeVersion;
import microsoft.exchange.webservices.data.MessageBody;
import microsoft.exchange.webservices.data.WebCredentials;

class EWSIntegrationMain {

	public static void main(String[] args) throws Exception {

		// Read the properties file in a reader
		//Make sure you have a properties file at the class path
		//having three properties
		//email: Email to be used to connect to Exchange server
		//password: Password of the email
		//url: URL to your exchange server. Read about Autodiscovery 
		//     also in Readme file of ews-java-api GitHub
		String fileName = "credentials.properties";
		Reader reader = new BufferedReader(new InputStreamReader(
				EWSIntegrationMain.class.getClassLoader().getResourceAsStream(
						fileName)));

		// Instantiate a properties object and load the reader
		Properties properties = new Properties();
		properties.load(reader);

		String email = properties.getProperty("email");
		String password = properties.getProperty("password");
		String ewsUrl = properties.getProperty("url");
		
		ExchangeService service = new ExchangeService(
				ExchangeVersion.Exchange2010_SP2);

		ExchangeCredentials credentials = new WebCredentials(
				email, password);
		service.setCredentials(credentials);

		service.setUrl(new URI(ewsUrl));
		
		//Let's send a message
		EmailMessage msg= new EmailMessage(service);
		msg.setSubject("Message using EWS API"); 
		msg.setBody(MessageBody.getMessageBodyFromText("Hope you are going to recieve this message."
				+ "If you get it than take the Ice Bucket Challenge"));
		
		//You can add multiple recipients
		msg.getToRecipients().add("<Recipient mail");
		
		//Send the message
		msg.send();

	}

}
