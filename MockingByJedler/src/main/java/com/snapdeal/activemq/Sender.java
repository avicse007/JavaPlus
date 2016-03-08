/**
 * 
 */
package com.snapdeal.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author Faheem Akhtar
 */


public class Sender {
    private static ConnectionFactory factory = null;
    private static Connection connection = null;
    private static Session session = null;
    private static Destination destination = null;
    private static MessageProducer producer = null;
    private static String queueName = null;

    public static void sendMessage(String messageToSend, String queue) throws JMSException {
        try {
            factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            queueName = queue;
            destination = session.createQueue(queueName);
            producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setText(messageToSend);
            producer.send(message);
            System.out.println("Sent: " + message.getText());
            connection.close();
        } finally{
        	connection.close();
        }
    }
}