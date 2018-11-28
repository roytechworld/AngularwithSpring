package com.proyprojects.spring.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class GenericServiceDaoImpl<T> {
	private static final Logger logger = LoggerFactory.getLogger(GenericServiceDaoImpl.class);	
	@SuppressWarnings("unchecked")
	public  List<T> getAnyDataGenericType(Class<? extends T> typelass,Session session) {
		List<T> slist=new ArrayList<T>();

		try
		{
			Criteria cr = session.createCriteria(typelass);
			cr.addOrder(Order.desc("vendorId"));
			slist  =cr.list();

		}
		catch(Exception e)  
		{
		logger.info("Error" +e);	
		}
	
		
		return slist;
	}

}
