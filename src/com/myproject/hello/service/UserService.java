package com.myproject.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myproject.hello.dao.impl.BaseDao;
import com.myproject.hello.entity.User;

@Service
public class UserService {

	@Autowired
	private BaseDao baseDao;
	
	public User getUserById(Integer userId) {
		return baseDao.selectById(userId);
	}
}
