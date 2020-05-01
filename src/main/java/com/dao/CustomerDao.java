package com.dao;

import java.util.List;

import com.entity.CityEntity;
import com.entity.CustomerEntity;
import com.entity.StateEntity;
import com.model.CustomerDto;

public interface CustomerDao {
	public List<StateEntity> getStates();
	public List<CityEntity> getCity();
	public void registerCustomer(CustomerEntity customerEntity);
	public CustomerEntity getCustomerDataUsingCustomerId(int customerId);
	public void updateCustomer(CustomerEntity customerEntity);
	public List<CityEntity> getCityListUsingStateName(String customerState);
	public void processUpdation(CustomerEntity customerEntity);
	public String deleteCustomer(String customerId);
}
