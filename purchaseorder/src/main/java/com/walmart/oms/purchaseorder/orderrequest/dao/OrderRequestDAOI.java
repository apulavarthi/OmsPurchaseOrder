package com.walmart.oms.purchaseorder.orderrequest.dao;

import java.util.List;

import com.walmart.oms.purchaseorder.orderrequest.model.OrderRequest;

public interface OrderRequestDAOI {

	public int[][] addBatchOrder(List<OrderRequest> list1,int batchSize);

	void addOrder(OrderRequest o1);

}
