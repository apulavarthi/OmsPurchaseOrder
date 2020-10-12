package com.walmart.oms.purchaseorder.orderrequest.activemq;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MyMessageSender {
	  @Autowired
	  private ConnectionFactory connectionFactory;
	  private JmsTemplate jmsTemplate;

	  @PostConstruct
	  public void init() {
	      this.jmsTemplate = new JmsTemplate(connectionFactory);
	  }

	  public void sendMessage(String queueName, long batchid) {
	      System.out.println("sending: " + batchid);
	      jmsTemplate.send("test", new MessageCreator() {
	          @Override
	          public TextMessage createMessage(Session session) throws JMSException {
	              return session.createTextMessage(String.valueOf(batchid));
	          }
	      });
	  }

}
