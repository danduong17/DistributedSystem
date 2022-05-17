// Lecture 4 - 04042022
// Example of JMS - Point-to-point implementation

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
