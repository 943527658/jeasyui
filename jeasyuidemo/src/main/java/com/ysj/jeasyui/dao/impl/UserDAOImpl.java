package com.ysj.jeasyui.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ysj.jeasyui.dao.UserDAO;
import com.ysj.jeasyui.db.RsMappingObject;
import com.ysj.jeasyui.db.SQLTemplate;
import com.ysj.jeasyui.db.SQLTemplateImpl;
import com.ysj.jeasyui.pojo.User;

public class UserDAOImpl implements UserDAO {

private SQLTemplate sqlT = null;
	
	
	
	public UserDAOImpl() {
		sqlT = new SQLTemplateImpl();
	}

	@SuppressWarnings("unchecked")
	public List<User> queryAll() {
		return (List<User>) sqlT.query("select * from users", null, new UserRsMappingObject());
	}


	public void add(User u) {
		sqlT.update("insert into users (firstname,lastname,phone,email) values (?,?,?,?)", 
				new Object[]{u.getFirstname(),u.getLastname(),u.getPhone(),u.getEmail()});
	}
	public void update(User u){
		sqlT.update("update users set firstname=?,lastname=?,phone=?,email=? where id = ?",
				new Object[]{u.getFirstname(),u.getLastname(),u.getPhone(),u.getEmail(),u.getId()});
	}
	public void delete(User u){
		sqlT.update("delete from users where id = ?",
				new Object[]{u.getId()});
	}
	
	
	class UserRsMappingObject implements RsMappingObject{

		public Object mapper2Obj(ResultSet rs) {
			User user = null;
			try {
				user = new User();
				user.setId(rs.getString("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		
	}
	
}
