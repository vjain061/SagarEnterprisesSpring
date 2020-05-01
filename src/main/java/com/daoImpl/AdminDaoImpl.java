package com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.dao.AdminDao;
import com.entity.AdminEntity;

@Repository
public class AdminDaoImpl implements AdminDao {

	public Session session;
	
	private SessionFactory getSessionFactory(){

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistryObj);
		return sessionFactory;
	
	}
	
	public boolean isAdminValidate(int adminId, String adminPassword) {
		SessionFactory sessionFactory =  getSessionFactory();
		Session session = sessionFactory.openSession();
		
		AdminEntity adminEntity = (AdminEntity)session.get(AdminEntity.class, new Integer(adminId));
		if(adminEntity.getAdminId() == adminId && adminEntity.getAdminPassword().equals(adminPassword)){
			return true;
		}
		return false;
	}

}
