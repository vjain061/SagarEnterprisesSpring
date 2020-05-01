package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {

	@Id
	@Column(name = "customerId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(name = "customerName")
	private String customerName;
	@Column(name = "customerLastName")
	private String customerLastName;
	@Column(name = "customerEmail")
	private String customerEmail;
	@Column(name = "customerMob")
	private String customerMob;
	@Column(name = "customerState")
	private String customerState;
	@Column(name = "customerCity")
	private String customerCity;
	
	@OneToMany(targetEntity = BillingEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId", insertable = false, updatable = false)
	private List<BillingEntity> billingEntityList;
	

	public List<BillingEntity> getBillingEntityList() {
		return billingEntityList;
	}

	public void setBillingEntityList(List<BillingEntity> billingEntityList) {
		this.billingEntityList = billingEntityList;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMob() {
		return customerMob;
	}

	public void setCustomerMob(String customerMob) {
		this.customerMob = customerMob;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", customerName=" + customerName + ", customerLastName="
				+ customerLastName + ", customerEmail=" + customerEmail + ", customerMob=" + customerMob
				+ ", customerState=" + customerState + ", customerCity=" + customerCity + "]";
	}

}
