package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.model.BillingDto;
import com.model.CustomerDto;
import com.serviceImpl.BillingServiceImpl;


@Controller
public class BillingController {
	
	@Autowired
	private BillingServiceImpl billingServiceImpl;

	@RequestMapping(value="gotoGenerateBillPage",method=RequestMethod.GET)
	public ModelAndView gotoGenerateBillPage(){
		ModelAndView modelAndView = new ModelAndView("GenerateBill");
		modelAndView.addObject("billingDto", new BillingDto());
		return modelAndView;
	}
	
	@RequestMapping(value="generateBill",method=RequestMethod.GET)
	public ModelAndView generateBill(@ModelAttribute("billingDto")BillingDto billingDto){
		String message = billingServiceImpl.generateBill(billingDto);
		ModelAndView modelAndView = new ModelAndView("ResultPage");
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	@RequestMapping(value="gotoSearchCustomerWhomBillingDuePage",method=RequestMethod.GET)
	public String gotoSearchCustomerWhomBillingDuePage(){
		return "SearchCustomerWhomeBillingDue";
	}
	
	@RequestMapping(value="searchBill",method=RequestMethod.GET)
	@ResponseBody
	public String searchBill(@RequestParam String customerId){
		if(customerId.isEmpty()){
			List<CustomerDto> customerDtoList  = billingServiceImpl.searchBillOfAllCustomers();
			
			for(CustomerDto customerDto : customerDtoList){
				System.out.println(customerDto);
				
				List<BillingDto> billingDto = customerDto.getBillingDtoList();
				for(BillingDto billingDto1 : billingDto){
					System.out.println(billingDto1);
				}
				
			}
			
			String gsonCustomerDtoList = new Gson().toJson(customerDtoList); 
			return gsonCustomerDtoList;
		}else{
			CustomerDto customerDto  = billingServiceImpl.searchBill(customerId);
			String gsonCustomerDtoList = new Gson().toJson(customerDto); 
			return gsonCustomerDtoList;
		}
	}
	
	@RequestMapping(value="payBill",method=RequestMethod.GET)
	@ResponseBody
	public String payBill(@RequestParam String idWithTime){
		System.out.println("idWithTime : "+idWithTime);
		
		
		
		
		
		String gsonCustomerDtoList = new Gson().toJson("VaibhavJain"); 
		return gsonCustomerDtoList;
	}
}
