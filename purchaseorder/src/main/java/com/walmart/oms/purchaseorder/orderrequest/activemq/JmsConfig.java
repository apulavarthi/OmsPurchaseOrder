package com.walmart.oms.purchaseorder.orderrequest.activemq;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

	String BROKER_URL = "tcp://localhost:61616"; 
	String BROKER_USERNAME = "admin"; 
	String BROKER_PASSWORD = "admin";
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory(){
	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	    connectionFactory.setBrokerURL(BROKER_URL);
	    connectionFactory.setPassword(BROKER_USERNAME);
	    connectionFactory.setUserName(BROKER_PASSWORD);
	    //connectionFactory.setTrustedPackages(new ArrayList(Arrays.asList("org.apache.activemq.test,org.apache.camel.test".split(","))));
	   //connectionFactory.setTrustedPackages(Arrays.asList("java.lang.Long"));
	    return connectionFactory;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory());
	    return template;
	}
	
	/*@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory());
	    factory.setConcurrency("1-1");
	    return factory;
	}*/
}
