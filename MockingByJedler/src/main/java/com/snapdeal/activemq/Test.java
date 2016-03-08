/**
 * 
 */
package com.snapdeal.activemq;

import javax.jms.JMSException;

/**
 * @author Faheem Akhtar
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		try {
			Sender.sendMessage("Faheem Akhtar Testing","localhost.queue");
		} catch (JMSException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Received:" + Receiver.receiveMessage("localhost.queue"));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
