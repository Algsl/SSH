package com.myproject.hello.dao.impl;

import com.myproject.hello.entity.User;

public interface BaseDao {
	void insert(User obj);

	void deleteById(Integer id);

	void update(User obj);

	User selectById(Integer id);

}
