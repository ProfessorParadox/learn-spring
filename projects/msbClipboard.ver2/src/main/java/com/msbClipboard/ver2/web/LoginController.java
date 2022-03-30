package com.msbClipboard.ver2.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msbClipboard.ver2.web.dao.LoginDao;


@Controller
public class LoginController extends HttpServlet {
	
	@RequestMapping("login")
	protected void doPost(@RequestParam("uname") String uname, @RequestParam("pass") String pass, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String uname = request.getParameter("uname");
//		String pass = request.getParameter("pass");
//		PrintWriter out = response.getWriter();
//		out.println("Welcome to Login Servlet");
		
		LoginDao logindao = new LoginDao();
		
		if(logindao.check(uname, pass)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			response.sendRedirect("dashboard.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
		
	}
	

}
