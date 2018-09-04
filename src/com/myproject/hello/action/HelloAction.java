package com.myproject.hello.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.myproject.hello.dao.UserDao;
import com.myproject.hello.entity.User;
import com.myproject.hello.service.UserService;

import net.sf.json.JSONArray;


public class HelloAction extends BaseAction{
	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	public String execute() {
		int userId=Integer.parseInt(request.getParameter("id"));
		UserService impl= (UserService) ac.getBean("userService");
		User user=impl.getUserById(userId);
		JSONArray jsonArray=JSONArray.fromObject(user);
		request.setAttribute("user", jsonArray);
		return "ok";
	}
}
