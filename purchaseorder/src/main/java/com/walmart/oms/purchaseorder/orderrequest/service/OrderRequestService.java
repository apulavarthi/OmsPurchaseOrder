package com.walmart.oms.purchaseorder.orderrequest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.walmart.oms.purchaseorder.orderrequest.activemq.MeesageProducer;
import com.walmart.oms.purchaseorder.orderrequest.activemq.MyMessageSender;
import com.walmart.oms.purchaseorder.orderrequest.dao.OrderRequestBatchDAOI;
import com.walmart.oms.purchaseorder.orderrequest.dao.OrderRequestDAOI;
import com.walmart.oms.purchaseorder.orderrequest.model.OrderRequest;
import com.walmart.oms.purchaseorder.orderrequest.model.OrderRequestBatch;



 @Component
 public class OrderRequestService {
	 
	@Autowired
	OrderRequestBatchDAOI batchDAOI;
	 
	@Autowired
	OrderRequestDAOI orderRequestDAOI;
	
	@Autowired
	RestTemplate rtemp;
	
	@Autowired
	MyMessageSender ms;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	 
	@Transactional 
	public long postBatchReq(OrderRequestBatch o1) {
		long startTime=System.currentTimeMillis();
		long batchid= batchDAOI.addReq(o1);
		//final String uri = "http://localhost:8080/getdcnbr/store/item";
		//int dcnbr=rtemp.getForObject(uri,Integer.class);
		
		List<OrderRequest> list1=o1.getOrderRequests();
		for (int i=0;i<list1.size();i++) {
			OrderRequest orderrequest=list1.get(i);
			orderrequest.setBatchid(batchid);
			/*final String uri = "http://localhost:8081/getdcnbr/"+orderrequest.getStore()+"/"+orderrequest.getItem();
			int dcnbr=rtemp.getForObject(uri,Integer.class);
			orderrequest.setDcnbr(dcnbr);*/
			//orderRequestDAOI.addOrder(orderrequest);
			
		}
		//mp.send(batchid);
		ms.sendMessage("test", batchid);
		orderRequestDAOI.addBatchOrder(list1, 10);
		long endTime=System.currentTimeMillis();
		System.out.println("total time " +(endTime-startTime));
		return batchid;
	}
	
	

}

