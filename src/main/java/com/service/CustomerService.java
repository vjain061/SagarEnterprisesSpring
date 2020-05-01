package com.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.entity.CityEntity;
import com.entity.CustomerEntity;
import com.entity.StateEntity;
import com.model.CustomerDto;

public interface CustomerService {
	public List<StateEntity> getStates();
	public List<CityEntity> getCity();
	public CustomerEntity convertCustomerDtoToCustomerEntity(CustomerDto customerDto);
	public void registerCustomer(CustomerEntity customerEntity);
	public CustomerDto getCustomerDataUsingCustomerId(int customerId);
	public void updateCustomer(CustomerDto customerDto);
	public List<CityEntity> getCityListUsingStateName(String customerState);
	public String convertCustomerDataToJson(CustomerDto customerDto,List<StateEntity> stateEntityList,List<CityEntity> cityEntityList);
	public CustomerDto getCustomerDtoFromNormalObject(int customerId, String customerName,String customerLastName,String customerState,String customerCity,String customerMob,String customerEmail);
	public void processUpdation(CustomerDto customerDto);
	public String deleteCustomer(String customerId);
}
