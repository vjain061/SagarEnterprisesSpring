package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.AdminDto;
import com.serviceImpl.AdminServiceImpl;

@Controller
public class AdminController {
	
	@Autowired
	public AdminServiceImpl adminServiceImpl;

	@RequestMapping(value = "/gotoAdminLoginPage", method = RequestMethod.GET)
	public ModelAndView gotoAdminLoginPage(ModelAndView modelAndView) {
		modelAndView.addObject("adminDto", new AdminDto());
		modelAndView.setViewName("AdminLogin");
		return modelAndView;
	}

	@RequestMapping(value = "/processAdminLogin", method = RequestMethod.GET)
	public ModelAndView processAdminLogin(@ModelAttribute("adminDto")AdminDto adminDto) {
		
		ModelAndView modelAndView = null;
		if(adminServiceImpl.isAdminValidate(adminDto.getAdminId(),adminDto.getAdminPassword())){
			modelAndView = new ModelAndView("AdminMenuPage");
			return modelAndView;
		}
		modelAndView = new ModelAndView("AdminLogin");
		modelAndView.addObject("message", "AdminId or AdminPassword is incorrect");
		return modelAndView;
	}
	
	@RequestMapping(value = "/gotoAdminMenuPage", method = RequestMethod.GET)
	public String gotoAdminMenuPage(){
		return "AdminMenuPage";
	}
	
	@RequestMapping(value = "/gotoCustomerMenuPage", method = RequestMethod.GET)
	public ModelAndView gotoCustomerMenuPage(ModelAndView modelAndView) {
		modelAndView.setViewName("CustomerMenu");
		return modelAndView;
	}
	
	@RequestMapping(value = "/gotoBillingPage", method = RequestMethod.GET)
	public ModelAndView gotoBillingPage(ModelAndView modelAndView) {
		modelAndView.setViewName("Billing");
		return modelAndView;
	}
	
	@RequestMapping(value = "/gotoAdvanceOptionsPage", method = RequestMethod.GET)
	public ModelAndView gotoAdvanceOptionsPage(ModelAndView modelAndView) {
		modelAndView.setViewName("AdvanceOptions");
		return modelAndView;
	}
	
}