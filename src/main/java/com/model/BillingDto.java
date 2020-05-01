package com.model;

public class BillingDto {
	private int billAmount;
	private int customerId;
	private String billDateTime;

	public String getBillDateTime() {
		return billDateTime;
	}

	public void setBillDateTime(String billDateTime) {
		this.billDateTime = billDateTime;
	}

	public BillingDto(int billAmount, String billDateTime) {
		this.billAmount = billAmount;
		this.billDateTime = billDateTime;
	}

	public BillingDto() {
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
