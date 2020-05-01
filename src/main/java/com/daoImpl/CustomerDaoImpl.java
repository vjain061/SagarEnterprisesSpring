package com.daoImpl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.dao.CustomerDao;
import com.entity.BillingEntity;
import com.entity.CityEntity;
import com.entity.CustomerEntity;
import com.entity.StateEntity;

@Repository
public class CustomerDaoImpl implements CustomerDao {
public Session session;
	
	private SessionFactory getSessionFactory(){

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistryObj);
		return sessionFactory;
	
	}
	public List<StateEntity> getStates() {
		SessionFactory sessionFactory =  getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from StateEntity");
		List<StateEntity> stateEntityList = query.list();
		
		return stateEntityList;
	}
	public List<CityEntity> getCity() {
		SessionFactory sessionFactory =  getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from CityEntity");
		List<CityEntity> cityEntityList = query.list();
		
		return cityEntityList;
	}
	@Override
	public void registerCustomer(CustomerEntity customerEntity) {
		SessionFactory sessionFactory =  getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int id = (int) session.save(customerEntity);
		transaction.commit();
	}
	@Override
	public CustomerEntity getCustomerDataUsingCustomerId(int customerId) {
		SessionFactory sessionFactory =  getSessionFactory();
		Session session = sessionFactory.openSession();
		return (CustomerEntity) session.get(CustomerEntity.class, customerId);
	}
	@Override
	public void updateCustomer(CustomerEntity customerEntity) {
		SessionFactory sessionFactory =  getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("vaibhav : "+customerEntity);
		session.update(customerEntity);
		transaction.commit();	
	}
	@Override
	public List<CityEntity> getCityListUsingStateName(String customerState) {
		SessionFactory sessionFactory =  getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(StateEntity.class);
		Criterion criterion = Restrictions.eq("stateName", customerState);
		
		criteria.add(criterion);
		List<StateEntity> stateList = criteria.list();
		return stateList.get(0).getCityList();
	}
	
	@Override
	public void processUpdation(CustomerEntity customerEntity) {
		SessionFactory sessionFactory =  getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		System.out.println("customerEntity.getCustomerId() : "+customerEntity.getCustomerId());
		session.update(customerEntity);
		
		transaction.commit();
		System.out.println("Customer record has been updated succesfully!!!!");
	}
	@Override
	public String deleteCustomer(String customerId) {
		SessionFactory sessionFactory = getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(BillingEntity.class);
		criteria.add(Restrictions.eq("customerId", Integer.parseInt(customerId)));
		BillingEntity billingEntity = (BillingEntity) criteria.uniqueResult();
		
		if(billingEntity != null){
			return "Your bill is due";
		}
		
		CustomerEntity customerEntity = (CustomerEntity) session.load(CustomerEntity.class, Integer.parseInt(customerId));
		session.delete(customerEntity);
		
		transaction.commit();
		return "Deletion success";
	}
}
