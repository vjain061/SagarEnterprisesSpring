package com.dao;

import java.util.List;

import com.entity.BillingEntity;
import com.entity.CustomerEntity;
import com.model.CustomerDto;

public interface BillingDao {
	public String generateBill(BillingEntity billingEntity);
	public CustomerEntity searchBill(String customerId);
	public List<CustomerEntity> searchBillOfAllCustomers();
	public String payBill(String customerId,String billDateTime);
}
