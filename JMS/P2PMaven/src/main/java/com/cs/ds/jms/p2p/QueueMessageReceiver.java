package com.cs.ds.jms.p2p;

//Lecture 4 - 04042022
//Example of JMS - Point-to-point implementation

/* 
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Properties;


public class QueueMessageReceiver implements MessageListener {
	private boolean stopReceivingMessages = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueMessageReceiver queueMessageReceiver = new QueueMessageReceiver();
		queueMessageReceiver.startReceivingMessages();
	}
	
	public void startReceivingMessages() {
		BufferedReader inlineReader = new BufferedReader (new InputStreamReader(System.in));
		
		try {
			// Prompt for the JNDI Queue connection factory name
			 
				System.out.println("Enter the Queue Connection Factory name:");
				String queueConnFactoryName = inlineReader.readLine();
				System.out.println("Enter the Queue name:");
				String queueName = inlineReader.readLine();
			 
			String queueConnFactoryName = "ConnectionFactory";
			String queueName = "dynamicQueues/Payment_Check";
			
			// Setup properties
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
            
			// Look up for the administered objects of the Queue
			InitialContext context = new InitialContext();
			
			QueueConnectionFactory queueConnFactory = (QueueConnectionFactory)context.lookup(queueConnFactoryName);
			Queue queueReference = (Queue) context.lookup(queueName);
			context.close();
			
			// Create the JMS objects from administered objects
			QueueConnection queueConnection = queueConnFactory.createQueueConnection();
			QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueReceiver queueMessageReceiver = queueSession.createReceiver(queueReference);
			queueMessageReceiver.setMessageListener(this);
			queueConnection.start();
			
			// Keep receiving the messages from the queue until the stop
			// receiving messages command is received
			while (!stopReceivingMessages) {
				Thread.sleep(1000);
			}
			
			// Clean up
			System.out.println("Message successfully received so far, Stop receiving messages!");
			queueConnection.close();
		}
		catch (NamingException | JMSException | InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public void onMessage (Message message) {
		try {
			String messageContent = ((TextMessage) message).getText();
			System.out.println(messageContent);
			if ("stop".equals(messageContent)) 
				stopReceivingMessages = true;
		}
		catch (JMSException e) {
			e.printStackTrace();
			stopReceivingMessages = true;
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

public class QueueMessageReceiver implements MessageListener {
    private boolean stopReceivingMessages = false;

    public static void main (String[] args) {
        QueueMessageReceiver queueMessageReceiver = new QueueMessageReceiver();
        queueMessageReceiver.startReceivingMessages();
    }

    public void startReceivingMessages() {
        BufferedReader inlineReader = new BufferedReader(new InputStreamReader(System. in));
        try {
            // Prompt for the JNDI Queue connection factory name
            //System.out.println("Enter the Queue Connection Factory name: ");
			//String queueConnFactoryName = inlineReader.readLine();
            //System.out.println("Enter the Queue name: ");
			//String queueName = inlineReader.readLine();
        	
            String queueConnFactoryName = "ConnectionFactory"; //inlineReader.readLine();
            String queueName = "dynamicQueues/Payment_Check"; //inlineReader.readLine();

            //Setup properties
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");

            // Look up for the administered objects of the Queue
            InitialContext context = new InitialContext(props);
            QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) context.lookup(queueConnFactoryName);
            Queue queueReference = (Queue) context.lookup(queueName);
            context.close() ;

            // Create the JMS objects from administered objects
            QueueConnection queueConnection = queueConnFactory.createQueueConnection();
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE) ;
            QueueReceiver queueMessageReceiver = queueSession.createReceiver(queueReference);
            queueMessageReceiver.setMessageListener(this);
            queueConnection.start () ;
            // Keep receiving the messages from the queue until the stop
            // receiving messages command is received
            while (!stopReceivingMessages) {
                Thread.sleep(1000);
            }

            // Clean Up
            System.out.println ( "Messages successfully received so far. Stop receiving messages! ");
            queueConnection.close();
        } catch (NamingException | JMSException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            String messageContent = ((TextMessage) message).getText();
            System.out.println(messageContent);
            if ("stop".equals(messageContent))
                stopReceivingMessages = true;
        } catch (JMSException e) {
            e.printStackTrace();
            stopReceivingMessages = true;
        }
    }
}

