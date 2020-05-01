package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing")
public class BillingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	private int billAmount;
	private int customerId;
	private String billDateTime;

	public String getBillDateTime() {
		return billDateTime;
	}

	public void setBillDateTime(String billDateTime) {
		this.billDateTime = billDateTime;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
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
