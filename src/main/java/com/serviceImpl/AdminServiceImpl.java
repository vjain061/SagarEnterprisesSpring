package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daoImpl.AdminDaoImpl;
import com.service.AdminService;

@Component
public class AdminServiceImpl implements AdminService{

	@Autowired
	public AdminDaoImpl adminDaoImpl;
	
	public boolean isAdminValidate(int adminId, String adminPassword) {
		return adminDaoImpl.isAdminValidate(adminId,adminPassword);
	}

}
