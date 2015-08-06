package com.ysj.jeasyui.service;

import java.util.List;

import com.ysj.jeasyui.pojo.User;

public interface UserService {

	public List<User> queryAllUser();
	public void addUser(User u);
	public void updateUser(User u);
	public void deleteUser(User u);
}
