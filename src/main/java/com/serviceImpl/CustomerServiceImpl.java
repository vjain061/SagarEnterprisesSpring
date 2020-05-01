package com.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.daoImpl.CustomerDaoImpl;
import com.entity.CityEntity;
import com.entity.CustomerEntity;
import com.entity.StateEntity;
import com.model.CustomerDto;
import com.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	public CustomerDaoImpl customerDaoImpl;
	public List<StateEntity> getStates() {
		return customerDaoImpl.getStates();
	}
	
	public List<CityEntity> getCity() {
		return customerDaoImpl.getCity();
	}
	
	public CustomerEntity convertCustomerDtoToCustomerEntity(CustomerDto customerDto) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setCustomerId(customerDto.getCustomerId());
		customerEntity.setCustomerName(customerDto.getCustomerName());
		customerEntity.setCustomerLastName(customerDto.getCustomerLastName());
		customerEntity.setCustomerMob(customerDto.getCustomerMob());
		customerEntity.setCustomerEmail(customerDto.getCustomerEmail());
		
		List<StateEntity> stateEntityList = getStates();
		customerEntity.setCustomerState(getStateNameFromStateId(stateEntityList,customerDto.getCustomerState()));
		
		customerEntity.setCustomerCity(customerDto.getCustomerCity());
		return customerEntity;
	}
	
	public CustomerDto convertCustomerEntityToCustomerDto(CustomerEntity customerEntity) {
		if(customerEntity != null){
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerId(customerEntity.getCustomerId());
			customerDto.setCustomerName(customerEntity.getCustomerName());
			customerDto.setCustomerLastName(customerEntity.getCustomerLastName());
			customerDto.setCustomerMob(customerEntity.getCustomerMob());
			customerDto.setCustomerEmail(customerEntity.getCustomerEmail());
			customerDto.setCustomerState(removeSpaceFromString(customerEntity.getCustomerState()));
			customerDto.setCustomerCity(customerEntity.getCustomerCity());
			return customerDto;
		}
		return null;
	}
	
	private String removeSpaceFromString(String inputString){
		String outputString = "";
		for(int i=0;i<inputString.length();i++){
			if(inputString.charAt(i) != ' ')
				outputString += inputString.charAt(i);
		}
		return outputString;
	}

	@Override
	public void registerCustomer(CustomerEntity customerEntity) {
		customerDaoImpl.registerCustomer(customerEntity);
	}
	
	public String getStateNameFromStateId(List<StateEntity> stateEntityList, String customerState) {
		List<StateEntity> stateEntity = stateEntityList.stream().filter(i -> i.getStateId() == Integer.parseInt(customerState)).collect(Collectors.toList());
		return stateEntity.get(0).getStateName();
	}

	@Override
	public CustomerDto getCustomerDataUsingCustomerId(int customerId) {
		return convertCustomerEntityToCustomerDto(customerDaoImpl.getCustomerDataUsingCustomerId(customerId));
	}

	@Override
	public void updateCustomer(CustomerDto customerDto) {
		CustomerEntity customerEntity = convertCustomerDtoToCustomerEntity(customerDto);
		customerDto.setCustomerState(getStateNameFromStateId(getStates(), customerDto.getCustomerState()));
		customerDaoImpl.updateCustomer(customerEntity);
	}

	@Override
	public List<CityEntity> getCityListUsingStateName(String customerState) {
		return customerDaoImpl.getCityListUsingStateName(customerState);
	}

	@Override
	public String convertCustomerDataToJson(CustomerDto customerDto, List<StateEntity> stateEntityList,
			List<CityEntity> cityEntityList) {

		String result = "{"+"\"customerCitySelected\""+":"+"\""+customerDto.getCustomerCity()+"\""+","
				+"\"customerEmail\""+":"+"\""+customerDto.getCustomerEmail()+"\""+","
				+"\"customerName\""+":"+"\""+customerDto.getCustomerName()+"\""+","
				+"\"customerLastName\""+":"+"\""+customerDto.getCustomerLastName()+"\""+","
				+"\"customerMob\""+":"+"\""+customerDto.getCustomerMob()+"\""+","
				+"\"customerStateSelected\""+":"+"\""+customerDto.getCustomerState()+"\""+","
				+"\"customerStates\""+":[";
				
				for(int i=0;i<stateEntityList.size();i++){
						if(i != stateEntityList.size()-1)
							result += "\""+stateEntityList.get(i).getStateName()+"\""+",";
						else
							result += "\""+stateEntityList.get(i).getStateName()+"\""+"],";
					
				}
				
				result += "\"customerCitys\""+":[";
				for(int i=0;i<cityEntityList.size();i++){
						if(i != cityEntityList.size()-1)
							result += "\""+cityEntityList.get(i).getCityName()+"\""+",";
						else
							result += "\""+cityEntityList.get(i).getCityName()+"\""+"]";
				}
				
				result += "}";
		return result;
	
	}

	@Override
	public CustomerDto getCustomerDtoFromNormalObject(int customerId, String customerName, String customerLastName, String customerState, String customerCity, String customerMob, String customerEmail) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(customerId);
		customerDto.setCustomerName(customerName);
		customerDto.setCustomerLastName(customerLastName);
		customerDto.setCustomerState(customerState);
		customerDto.setCustomerCity(customerCity);
		customerDto.setCustomerMob(customerMob);
		customerDto.setCustomerEmail(customerEmail);
		return customerDto;
	}

	@Override
	public void processUpdation(CustomerDto customerDto) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setCustomerId(customerDto.getCustomerId());
		customerEntity.setCustomerName(customerDto.getCustomerName());
		customerEntity.setCustomerLastName(customerDto.getCustomerLastName());
		customerEntity.setCustomerMob(customerDto.getCustomerMob());
		customerEntity.setCustomerEmail(customerDto.getCustomerEmail());
		
		customerEntity.setCustomerState(customerDto.getCustomerState());
		
		customerEntity.setCustomerCity(customerDto.getCustomerCity());
		customerDaoImpl.processUpdation(customerEntity);
	}

	@Override
	public String deleteCustomer(String customerId) {
		return customerDaoImpl.deleteCustomer(customerId);
		
	}
}
