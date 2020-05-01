package com.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.daoImpl.BillingDaoImpl;
import com.entity.BillingEntity;
import com.entity.CustomerEntity;
import com.model.BillingDto;
import com.model.CustomerDto;
import com.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingDaoImpl billingDaoImpl;
	
	@Override
	public String generateBill(BillingDto billingDto) {
		BillingEntity billingEntity = convertBillingDtoToBillingEntity(billingDto);
		return billingDaoImpl.generateBill(billingEntity);
	}
	
	private BillingEntity convertBillingDtoToBillingEntity(BillingDto billingDto){
		BillingEntity billingEntity = new BillingEntity();
		billingEntity.setBillAmount(billingDto.getBillAmount());
		LocalDateTime localDateTime = LocalDateTime.now();
		billingEntity.setBillDateTime(localDateTime.toString());
		billingEntity.setCustomerId(billingDto.getCustomerId());
		return billingEntity;
	}
	
	private CustomerDto convertBillingDtoToBillingEntity(CustomerEntity customerEntity){
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerName(customerEntity.getCustomerName());
		customerDto.setCustomerLastName(customerEntity.getCustomerLastName());
		customerDto.setCustomerCity(customerEntity.getCustomerCity());
		customerDto.setCustomerState(customerEntity.getCustomerState());
		customerDto.setCustomerMob(customerEntity.getCustomerMob());
		customerDto.setCustomerEmail(customerEntity.getCustomerEmail());
		customerDto.setCustomerId(customerEntity.getCustomerId());
		
		List<BillingEntity> billingEntityList = customerEntity.getBillingEntityList();
		
		List<BillingDto> billingDtoList = new ArrayList<>();
		for(BillingEntity billingEntity : billingEntityList){
			BillingDto billingDto = new BillingDto();
			billingDto.setBillAmount(billingEntity.getBillAmount());
			billingDto.setCustomerId(billingEntity.getCustomerId());
			billingDto.setBillDateTime(billingEntity.getBillDateTime());
			billingDtoList.add(billingDto);
		}
		customerDto.setBillingDtoList(billingDtoList);
		return customerDto;
	}

	@Override
	public CustomerDto searchBill(String customerId) {
		CustomerEntity customerEntity = billingDaoImpl.searchBill(customerId);
		CustomerDto customerDto = convertBillingDtoToBillingEntity(customerEntity);
		return customerDto;
	}

	public List<CustomerDto> searchBillOfAllCustomers() {
		List<CustomerEntity> customerEntityList  = billingDaoImpl.searchBillOfAllCustomers();
		List<CustomerDto> customerDtoList = convertCustomerEntityListToCustomerDtoList(customerEntityList);
		return customerDtoList;
	}

	private List<CustomerDto> convertCustomerEntityListToCustomerDtoList(List<CustomerEntity> customerEntityList) {
		List<CustomerDto> customerDtoList = new ArrayList<CustomerDto>();
		
		for(CustomerEntity customerEntity : customerEntityList){
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerId(customerEntity.getCustomerId());
			customerDto.setCustomerName(customerEntity.getCustomerName());
			customerDto.setCustomerLastName(customerEntity.getCustomerLastName());
			customerDto.setCustomerCity(customerEntity.getCustomerCity());
			customerDto.setCustomerState(customerEntity.getCustomerState());
			customerDto.setCustomerMob(customerEntity.getCustomerMob());
			customerDto.setCustomerEmail(customerEntity.getCustomerEmail());
			
			List<BillingEntity> billingEntityList = customerEntity.getBillingEntityList();
			
			List<BillingDto> billingDtoList = new ArrayList<>();
			for(BillingEntity billingEntity : billingEntityList){
				BillingDto billingDto = new BillingDto();
				billingDto.setBillAmount(billingEntity.getBillAmount());
				billingDto.setCustomerId(billingEntity.getCustomerId());
				billingDto.setBillDateTime(billingEntity.getBillDateTime());
				billingDtoList.add(billingDto);
			}
			customerDto.setBillingDtoList(billingDtoList);
			customerDtoList.add(customerDto);
		}
		
		return customerDtoList;
	}
	
	public String payBill(String idWithTime){
		String customerId = idWithTime.substring(0,1);
		String billDateTime = idWithTime.substring(1,idWithTime.length()-1);
		return billingDaoImpl.payBill(customerId, billDateTime);
	}
}
