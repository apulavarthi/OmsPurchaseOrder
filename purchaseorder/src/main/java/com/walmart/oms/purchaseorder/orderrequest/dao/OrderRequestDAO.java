package com.walmart.oms.purchaseorder.orderrequest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.walmart.oms.purchaseorder.orderrequest.model.OrderRequest;

@Repository
public class OrderRequestDAO implements OrderRequestDAOI{

	@Autowired
	JdbcTemplate jtemp;
	
	@Override
	public void addOrder(OrderRequest o1) {
		long startTime= System.currentTimeMillis();
		String sql="INSERT INTO oms.order_request (item, store, qty, mabd,batchid,dcnbr) VALUES (?,?,?,?,?,?)";
		jtemp.update(sql,o1.getItem(),o1.getStore(),o1.getQty(),o1.getMabd(),o1.getBatchid(),o1.getDcnbr());
		long endTime= System.currentTimeMillis();
		System.out.println("total timr" +(endTime-startTime));
	
	}

	@Override
	public int[][] addBatchOrder(List<OrderRequest> list1,int batchSize) {
		 int[][] insertcounts=jtemp.batchUpdate(
	                "INSERT INTO oms.order_request (item, store, qty, mabd,batchid) VALUES (?,?,?,?,?)",
	                list1,
	                batchSize,
	                new ParameterizedPreparedStatementSetter<OrderRequest>() {

	                    public void setValues(PreparedStatement ps, OrderRequest o1)
							throws SQLException {
	                        ps.setInt(1, o1.getItem());
	                        ps.setInt(2,o1.getStore());
	                        ps.setInt(3, o1.getQty());
	                        ps.setString(4,o1.getMabd());
	                        ps.setLong(5, o1.getBatchid());
	                        //ps.setInt(6,o1.getDcnbr());
		 
	                    }
	                 
	                });
		 return insertcounts;
		
	}

	
	

}
