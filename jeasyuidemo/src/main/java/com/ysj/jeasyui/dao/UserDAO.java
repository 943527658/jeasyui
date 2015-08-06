package com.ysj.jeasyui.dao;

import java.util.List;

import com.ysj.jeasyui.pojo.User;

public interface UserDAO {
	public List<User> queryAll();
	public void add(User u);
	public void update(User u);
	public void delete(User u);
}
