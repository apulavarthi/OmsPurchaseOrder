package com.walmart.oms.purchaseorder.orderrequest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.oms.purchaseorder.orderrequest.dao.OrderRequestBatchDAOI;
import com.walmart.oms.purchaseorder.orderrequest.dao.OrderRequestDAOI;
import com.walmart.oms.purchaseorder.orderrequest.model.OrderRequest;
import com.walmart.oms.purchaseorder.orderrequest.model.OrderRequestBatch;
import com.walmart.oms.purchaseorder.orderrequest.service.OrderRequestService;

@RestController
public class OrderRequestController {

	@Autowired
	OrderRequestService os;
	
	
	
	//@PostMapping(path="/addorder",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	//public long postOdr(@RequestBody OrderRequest o1)
	{
		
		//long aa=or.addOrder(o1);
		//System.out.println("batchid " +aa);
		//return aa;
		
		//return o1.getBatchid();
	}
	
	@PostMapping(path="/addorder",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public long postReq(@RequestBody OrderRequestBatch o1)
	{
		long bb=os.postBatchReq(o1);
		return bb;
	}
	
	@GetMapping(path="/getorder",produces=MediaType.APPLICATION_JSON_VALUE)
	public OrderRequestBatch getReq()
	{
		OrderRequestBatch ob = new OrderRequestBatch();
		ob.setCreatedby("raj");
		ob.setCreatets("2020-09-04");
		ob.setStatus(0);
		List<OrderRequest> list1=new ArrayList<OrderRequest>();
		OrderRequest orderrequest1 = new OrderRequest();
		orderrequest1.setItem(1003);
		orderrequest1.setStore(100);
		orderrequest1.setQty(2000);
		
		OrderRequest orderrequest2= new OrderRequest();
		orderrequest2.setItem(1103);
		orderrequest2.setStore(100);
		orderrequest2.setQty(2080);
		
		list1.add(orderrequest1);
		list1.add(orderrequest2);
		
		ob.setOrderRequests(list1);
		
		return ob;
		
	}
}
