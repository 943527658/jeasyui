package com.ysj.jeasyui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.ysj.jeasyui.pojo.User;
import com.ysj.jeasyui.service.UserService;
import com.ysj.jeasyui.service.impl.UserServiceImpl;
import com.ysj.jeasyui.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UserServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6444513511906295578L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("m");
		UserService us =new UserServiceImpl();
		if ("lst".equals(method)){
			List<User> l = us.queryAllUser();
			String jsonStr = JsonUtil.toJson(l);
			PrintWriter out = resp.getWriter();
			out.println(jsonStr);
		} else if("add".equals(method)){
			
			String fname = req.getParameter("firstname");
			String lname = req.getParameter("lastname");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			User u = new User();
			u.setFirstname(fname);
			u.setLastname(lname);
			u.setPhone(phone);
			u.setEmail(email);
			us.addUser(u);
		}else if("update".equals(method)){
			
			String fname = req.getParameter("firstname");
			String lname = req.getParameter("lastname");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			String id = req.getParameter("id");
			User u = new User();
			u.setFirstname(fname);
			u.setLastname(lname);
			u.setPhone(phone);
			u.setEmail(email);
			u.setId(id);
			us.updateUser(u);
			
		}else if("delete".equals(method)){
			

			String id = req.getParameter("id");
			User u = new User();
			u.setId(id);
			us.deleteUser(u);
			
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
