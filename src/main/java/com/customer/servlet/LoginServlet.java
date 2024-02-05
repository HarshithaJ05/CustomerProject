package com.customer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.daoIml.AdminDaoIml;
import com.customer.module.Admin;
import com.customer.util.J2EEHttpPost;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		AdminDaoIml adminDaoIml = new AdminDaoIml();
		List<Admin> allUser = adminDaoIml.getAllUser();
		String authtoken = J2EEHttpPost.sendPostRequest(username, password);

		if (authtoken != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", authtoken);
			request.getRequestDispatcher("home.jsp").forward(request, response);

		}

		else {
			request.setAttribute("errorPage", "You are not logined");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}

}
