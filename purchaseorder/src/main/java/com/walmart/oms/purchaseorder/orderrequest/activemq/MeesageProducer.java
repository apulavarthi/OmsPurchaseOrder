package com.walmart.oms.purchaseorder.orderrequest.activemq;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MeesageProducer {
	@Autowired
	private JmsTemplate jmsTemplate;
	public void send(long batchid) {
		Long batchIdWrapper = new Long(batchid);
		jmsTemplate.convertAndSend("test", batchIdWrapper);
	}
	 
}
