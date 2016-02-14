/**
 * 
 */
package com.snapdeal.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author Faheem Akhtar
 */

public class Receiver {
    private static ConnectionFactory factory = null;
    private static Connection connection = null;
    private static Session session = null;
    private static Destination destination = null;
    private static MessageConsumer consumer = null;
    private static String queueName = null;

    public static String receiveMessage(String queue) throws JMSException {
        try {
            factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            queueName = queue;
            destination = session.createQueue(queueName);
            consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            if (message instanceof TextMessage) {
                TextMessage text = (TextMessage) message;
                return text.getText();
            }
        } finally{
        	connection.close();
        }
		return null;
    }
}