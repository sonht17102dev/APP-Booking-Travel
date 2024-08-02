package com.sonht.controller.client;

import java.io.IOException;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

import com.sonht.controllerAdmin.BaseController;
import com.sonht.model.User;

@WebServlet("/login")
public class LoginController extends BaseController {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("action", "login");
		request.getRequestDispatcher("/views/admin/pages/authForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		String authenPath = "/views/admin/pages/authForm.jsp";
		String adminPath = "/views/admin/pages/home.jsp";
		// if email and password not valid
		if (!isValidEmail(email) && !isValidPassword(pass)) {
			request.setAttribute("message", "Invalid Email or Invalid Pass!");
			request.setAttribute("action", "login");
			request.getRequestDispatcher(authenPath).forward(request, response);
		}

		try {
			User user = getUserDAO().checkEmailExist(email);
			// if user email is not exist
			if (user == null) {
				request.setAttribute("message", "User mail is not exist! Try again!");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/views/admin/pages/authForm.jsp").forward(request, response);
			} else {
				// if pass is not correct
				if (!pass.equals(user.getPassword())) {
					request.setAttribute("message", "Password is not correct! Try again!");
					request.setAttribute("action", "login");
					request.getRequestDispatcher(authenPath).forward(request, response);
				}
				// if user is admin 
				if (user.getRoleId() == 0) {
					session.setAttribute("adminLogin", user);
					session.setAttribute("message", "Login Success");
					session.setMaxInactiveInterval(60);
					request.getRequestDispatcher(adminPath).forward(request, response);
				}
					
				session.setAttribute("userLogin", user);
				session.setAttribute("message", "Login Success");
				session.setMaxInactiveInterval(60);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
