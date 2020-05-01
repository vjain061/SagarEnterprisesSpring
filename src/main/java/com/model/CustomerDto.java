package com.model;

import java.util.List;

public class CustomerDto {
	private String customerCity;
	private String customerEmail;
	private int customerId;
	private String customerLastName;
	private String customerMob;
	private String customerName;
	private String customerState;
	private List<BillingDto> billingDtoList; 
	

	public List<BillingDto> getBillingDtoList() {
		return billingDtoList;
	}

	public void setBillingDtoList(List<BillingDto> billingDtoList) {
		this.billingDtoList = billingDtoList;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public String getCustomerMob() {
		return customerMob;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public void setCustomerMob(String customerMob) {
		this.customerMob = customerMob;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	@Override
	public String toString() {
		return "CustomerDto [customerCity=" + customerCity + ", customerEmail=" + customerEmail + ", customerId="
				+ customerId + ", customerLastName=" + customerLastName + ", customerMob=" + customerMob
				+ ", customerName=" + customerName + ", customerState=" + customerState + ", billingDtoList="
				+ billingDtoList + "]";
	}

}
