package com.amazon.cart1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.cart1.model.Category;
import com.amazon.cart1.model.Category;

@EnableTransactionManagement
@Repository(value="categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
public boolean save(Category category){
	try {
		sessionFactory.getCurrentSession().save(category);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;}
	}
	@Transactional
	public boolean update(Category category){
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;}
		}
		@Transactional
		public boolean delete(Category category){
			try {
				sessionFactory.getCurrentSession().delete(category);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
}
		 
		@Transactional
		public Category get(String id)
		{
			String hql="from Category where id="+"'"+id+"'";
					Query query=sessionFactory.getCurrentSession().createQuery(hql);
					List<Category> list=query.list();
					if(list==null || list.isEmpty()){
						return null;
					}
					else{
						return list.get(0);
						
					}
		}
				@Transactional
		public	List<Category> list(){
			String hql="from Category";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
				
			}
		}


