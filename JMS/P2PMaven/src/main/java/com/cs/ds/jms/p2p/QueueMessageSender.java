package com.cs.ds.jms.p2p;

//Lecture 4 - 04042022
//Example of JMS - Point-to-point implementation

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.*;
import javax.naming.InitialContext;

public class QueueMessageSender {
	public static void main(String[] args) {
		QueueMessageSender messageSender = new QueueMessageSender();
		messageSender.enqueueMessage();
	}
	
	 public void enqueueMessage() {
		 BufferedReader inlineReader = new BufferedReader(new InputStreamReader (System.in));
		 try {
			// Prompt for the JNDI Queue connection factory name
			
			System.out.println("Enter the Queue Connection Factory name:");
			String queueConnFactoryName = inlineReader.readLine();
			System.out.println("Enter the Queue name:");
			String queueName = inlineReader.readLine();
			 
	         // String queueConnFactoryName = "ConnectionFactory";
	         // String queueName = "dynamicQueues/Payment_Check";

			 // Look up for the administered objects of the Queue
			 InitialContext context = new InitialContext();
			 QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) context.lookup(queueConnFactoryName);
			 Queue queueReference = (Queue) context.lookup(queueName);
			 context.close();
			 
			 // Create the JMS objects from administered objects
			 QueueConnection queueConnection = queueConnFactory.createQueueConnection();
			 QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			 QueueSender queueSender = queueSession.createSender(queueReference);
			 
			 // Enqueue multiple text message entered one after the other
			 String messageContent = null;
			 while (true) {
				 System.out.println("Enter the new message to send or 'abandon' to exit the program:");
				 messageContent = inlineReader.readLine();
				 if ("abandon".equals(messageContent))
					 break;
				 TextMessage textMessage = queueSession.createTextMessage(messageContent);
				 queueSender.send(textMessage);
			 }
			 
			 // Clean up
			 System.out.println("Message successfully posted to the queue...");
			 inlineReader.close();
			 queueConnection.close();
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
}
*/

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class QueueMessageSender {
    public static void main(String[] args) {
        QueueMessageSender messageSender = new QueueMessageSender();
        messageSender.enqueueMessage();
    }

    public void enqueueMessage() {
        BufferedReader inlineReader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            // Prompt for the JNDI Queue connection factory name
            //System.out.println("Enter the Queue Connection Factory name: ");
			//String queueConnFactoryName = inlineReader.readLine();
            //System.out.println("Enter the Queue name: ");
			//String queueName = inlineReader.readLine();

            String queueConnFactoryName = "ConnectionFactory";
            String queueName = "dynamicQueues/Payment_Check";

            //Setup properties
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");

            // Look up for the administered objects of the Queue
            InitialContext context = new InitialContext(props);
            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) context.lookup(queueConnFactoryName);
            Queue queueReference = (Queue) context.lookup(queueName);
            context.close();

            // Create the JMS objects from administered objects
            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueSender queueSender = queueSession.createSender(queueReference);

            // Enqueue multiple text messages entered one after the other
            String messageContent = null;
            while (true) {
                System.out.println("Enter the new message to send or 'stop' to exit the program: ");
                messageContent = inlineReader.readLine();
                TextMessage textMessage = queueSession.createTextMessage(messageContent);
                queueSender.send(textMessage);
                if ("stop".equals(messageContent))
                    break;
            }
            // Clean Up
            System.out.println ("Messages Successfully posted to the queue... ");
            inlineReader.close () ;
            queueConnection.close();
        } catch (IOException | NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
