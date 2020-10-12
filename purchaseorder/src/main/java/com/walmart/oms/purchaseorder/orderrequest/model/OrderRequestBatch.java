package com.walmart.oms.purchaseorder.orderrequest.model;

import java.util.List;

public class OrderRequestBatch {
	
	private long batchid;
	private String createdby;
	private String createts;
	private int status;
	private List<OrderRequest> orderRequests;
	
	public long getBatchid() {
		return batchid;
	}
	public void setBatchid(long batchid) {
		this.batchid = batchid;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getCreatets() {
		return createts;
	}
	public void setCreatets(String createts) {
		this.createts = createts;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<OrderRequest> getOrderRequests() {
		return orderRequests;
	}
	public void setOrderRequests(List<OrderRequest> orderRequests) {
		this.orderRequests = orderRequests;
	}
	

}
