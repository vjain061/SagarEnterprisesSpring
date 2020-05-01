package com.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entity.CityEntity;
import com.entity.CustomerEntity;
import com.entity.StateEntity;
import com.google.gson.Gson;
import com.model.CustomerDto;
import com.serviceImpl.CustomerServiceImpl;

@Controller
public class CustomerController {
	@Autowired
	public CustomerServiceImpl customerServiceImpl;
	
	@RequestMapping(value="/gotoRegisterCustomerPage", method = RequestMethod.GET)
	public ModelAndView gotoRegisterCustomerPage(){
		ModelAndView modelAndView = new ModelAndView("RegisterCustomer");
		
		List<StateEntity> customerStateList = customerServiceImpl.getStates();
		modelAndView.addObject("customerStateList", customerStateList);
		modelAndView.addObject("customerDto", new CustomerDto());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/getCustomerDataForUpdate", method = RequestMethod.GET)
	@ResponseBody
	public String getCustomerDataForUpdate(@RequestParam("customerId") String customerId,HttpServletRequest httpServletRequest){
		CustomerDto customerDto = customerServiceImpl.getCustomerDataUsingCustomerId(Integer.parseInt(customerId));
		httpServletRequest.getSession().setAttribute("customerId", customerId);
		List<StateEntity> stateEntityList = customerServiceImpl.getStates();
		List<CityEntity> cityEntityList = customerServiceImpl.getCityListUsingStateName(customerDto.getCustomerState());
		
		return customerServiceImpl.convertCustomerDataToJson(customerDto,stateEntityList,cityEntityList);
	}
	
	@RequestMapping(value="/gotoDeleteCustomerPage", method = RequestMethod.GET)
	public ModelAndView gotoDeleteCustomerPage(){
		ModelAndView modelAndView = new ModelAndView("DeleteCustomer");
		return modelAndView;
	}
	
	@RequestMapping(value="/gotoViewCustomerPage", method = RequestMethod.GET)
	public ModelAndView gotoViewCustomerPage(){
		ModelAndView modelAndView = new ModelAndView("ViewCustomer");
		return modelAndView;
	}
	
	@RequestMapping(value="/gotoUpdateCustomerIdPage", method = RequestMethod.GET)
	public ModelAndView gotoUpdateCustomerIdPage(){
		ModelAndView modelAndView = new ModelAndView("UpdateCustomerNew");
		return modelAndView;
	}
	
	@RequestMapping(value="/getCustomerDataUsingId", method = RequestMethod.GET)
	@ResponseBody
	public String getCustomerDataUsingId(@RequestParam("customerId") String customerId){
		CustomerDto customerDto = customerServiceImpl.getCustomerDataUsingCustomerId(Integer.parseInt(customerId));
		String gsonCityList = new Gson().toJson(customerDto);
		return gsonCityList;
	}
	
	@RequestMapping(value="/registerCustomer", method = RequestMethod.GET)
	public ModelAndView registerCustomer(@ModelAttribute("customerDto") CustomerDto customerDto){
		CustomerEntity customerEntity = customerServiceImpl.convertCustomerDtoToCustomerEntity(customerDto);
		customerServiceImpl.registerCustomer(customerEntity);
		ModelAndView modelAndView = new ModelAndView("ViewCustomer");
		modelAndView.addObject("customerDto", customerDto);
		customerDto.setCustomerState(customerServiceImpl.getStateNameFromStateId(customerServiceImpl.getStates(), customerDto.getCustomerState()));
		return modelAndView;
	}
	
	@RequestMapping(value="/getCityUsingStateId", method = RequestMethod.GET)
	@ResponseBody
	public String getCityUsingStateId(@RequestParam int stateId){
		List<StateEntity> customerStateList = customerServiceImpl.getStates();
		
		List<StateEntity> stateEntityList =
				customerStateList.stream()
			           .filter(e -> e.getStateId() == stateId).collect(Collectors.toList());
		
		List<CityEntity> cityEntityList = stateEntityList.get(0).getCityList();
		
		String gsonCityList = new Gson().toJson(cityEntityList);
		return gsonCityList;
	}
	
	@RequestMapping(value="getCustomerDataUsingCustomerId",method=RequestMethod.GET)
	@ResponseBody
	public String getCustomerDataUsingCustomerId(@RequestParam int customerId){
		CustomerDto customerDto = customerServiceImpl.getCustomerDataUsingCustomerId(customerId);
		String gsonCustomerDto = new Gson().toJson(customerDto);
		return gsonCustomerDto;
	}
	
	@RequestMapping(value="processUpdation",method=RequestMethod.GET)
	public void processUpdation(@RequestParam String customerName,@RequestParam String customerLastName,@RequestParam String customerState,
			@RequestParam String customerCity,@RequestParam String customerMob,@RequestParam String customerEmail,HttpServletRequest httpServletRequest){
		/*
		 * getCustomerDtoFromNormalObject method will convert all the above values to CustomerDto object
		 */
		CustomerDto customerDto = customerServiceImpl.getCustomerDtoFromNormalObject(Integer.parseInt(httpServletRequest.getSession().getAttribute("customerId").toString()),customerName,
				customerLastName, customerState, customerCity, customerMob, customerEmail);
		customerServiceImpl.processUpdation(customerDto);
	}
	
	@RequestMapping(value="deleteCustomer",method=RequestMethod.GET)
	@ResponseBody
	public String deleteCustomer(@RequestParam String customerId){
		String result = customerServiceImpl.deleteCustomer(customerId);
		String gsonCustomerDto = new Gson().toJson(result);
		return gsonCustomerDto;
	}
	
}
