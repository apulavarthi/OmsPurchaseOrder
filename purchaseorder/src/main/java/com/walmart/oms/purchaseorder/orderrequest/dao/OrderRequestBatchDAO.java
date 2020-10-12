package com.walmart.oms.purchaseorder.orderrequest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.walmart.oms.purchaseorder.orderrequest.model.OrderRequestBatch;

@Repository
public class OrderRequestBatchDAO implements OrderRequestBatchDAOI{
	
	@Autowired
	JdbcTemplate jtemp;

	@Override
	public long addReq(OrderRequestBatch o1) {
		long startTime= System.currentTimeMillis();
		String sql="INSERT INTO order_request_batch (createdby, createts, status) VALUES (?,?,?)";
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jtemp.update(new PreparedStatementCreator() {
		    @Override
		    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		        PreparedStatement statement = con.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS);
		        statement.setString(1, o1.getCreatedby());
		        statement.setString(2, o1.getCreatets());
		        statement.setInt(3, o1.getStatus());
		        return statement;
		    }
		}, holder);
		long primaryKey = holder.getKey().longValue();
		o1.setBatchid(primaryKey);
		long endTime= System.currentTimeMillis();
		System.out.println(" ORB total time" +(endTime-startTime));
		return o1.getBatchid();
	}
	
	

	

}
