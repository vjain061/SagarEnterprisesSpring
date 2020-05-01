package com.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.dao.BillingDao;
import com.entity.BillingEntity;
import com.entity.CustomerEntity;
import com.model.CustomerDto;

@Component
public class BillingDaoImpl implements BillingDao {

public Session session;
	
	private SessionFactory getSessionFactory(){

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistryObj);
		return sessionFactory;
	
	}
	
	@Override
	public String generateBill(BillingEntity billingEntity) {
		SessionFactory sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		
		CustomerEntity customerEntity = (CustomerEntity) session.get(CustomerEntity.class,billingEntity.getCustomerId());
		if(customerEntity == null)
			return "Customer not registered please register first";
		
		Transaction transaction = session.beginTransaction();
		int billId = (int) session.save(billingEntity);
		transaction.commit();
		System.out.println("Bill has been generated with "+billId+" id");
		return "Bill has been generated succesfully";
	}

	@Override
	public CustomerEntity searchBill(String customerId) {
		SessionFactory sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		
		/*Criteria criteria = session.createCriteria(BillingEntity.class);
		criteria.add(Restrictions.eq("customerId", Integer.parseInt(customerId)));
		
		List<BillingEntity> billingEntityList = (List<BillingEntity>) criteria.list();*/
		
		Query query = session.createQuery("from CustomerEntity where customerId = ?");
		query.setParameter(0, Integer.parseInt(customerId));
		CustomerEntity customerEntity = (CustomerEntity) query.uniqueResult();//list();
		System.out.println("customerEntityList : "+customerEntity);
		
		return customerEntity;
	}

	@Override
	public List<CustomerEntity> searchBillOfAllCustomers() {
		SessionFactory sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CustomerEntity.class);
		List<CustomerEntity> customerEntityList = (List<CustomerEntity>) criteria.list();
		return customerEntityList;
	}

	@Override
	public String payBill(String customerId, String billDateTime) {
		
		return "Bill has been paid successfully!!!";
	}
	
	

}
