package com.myproject.hello.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.myproject.hello.dao.impl.BaseDao;
import com.myproject.hello.entity.User;
import com.myproject.hello.util.HibernateUtil;

@Service
public class UserDao implements BaseDao{

	@Override
	public void insert(User obj) {
		Session session=HibernateUtil.getSession();
		Transaction tr=session.beginTransaction();
		session.save(obj);
		tr.commit();
	}

	@Override
	public void deleteById(Integer id) {
		Session session=HibernateUtil.getSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from user_t where id=?");
		query.setParameter(0, id);
		User user=null;
		try {
			user=(User) query.list().get(0);
			session.delete(user);
		}catch(Exception e) {
			
		}
		tr.commit();
	}

	@Override
	public void update(User obj) {
		Session session=HibernateUtil.getSession();
		Transaction tr=session.beginTransaction();
		session.update(obj);
		tr.commit();
	}

	@Override
	public User selectById(Integer id) {
		Session session=HibernateUtil.getSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from User where id=?");
		query.setParameter(0, id);
		User user=null;
		try {
			user=(User) query.list().get(0);
		}catch(Exception e) {
			
		}
		tr.commit();
		return user;
	}

	/*public static void main(String args[]) {
		UserDao dao=new UserDao();
		User user=(User) dao.selectById(1);
		System.out.println(user.getPassword());
	}*/
}
