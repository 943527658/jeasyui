package com.ysj.jeasyui.service.impl;

import java.util.List;

import com.ysj.jeasyui.dao.UserDAO;
import com.ysj.jeasyui.dao.impl.UserDAOImpl;
import com.ysj.jeasyui.pojo.User;
import com.ysj.jeasyui.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO userDao = new UserDAOImpl();

	public List<User> queryAllUser() {
		List<User> l = userDao.queryAll();
		return l;
	}

	public void addUser(User u) {
		userDao.add(u);

	}
	
	public void updateUser(User u){
		userDao.update(u);
	}
	public void deleteUser(User u){
		userDao.delete(u);
	}
}
