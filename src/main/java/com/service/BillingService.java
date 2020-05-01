package com.service;

import java.util.List;

import com.model.BillingDto;
import com.model.CustomerDto;

public interface BillingService {
	public String generateBill(BillingDto billingDto);
	public CustomerDto searchBill(String customerId);
	public List<CustomerDto> searchBillOfAllCustomers();
	public String payBill(String idWithTime);
}
