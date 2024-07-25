package com.sonht.controllerAdmin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.compiler.NewlineReductionServletWriter;
import org.eclipse.jdt.internal.compiler.IDebugRequestor;

import com.google.gson.Gson;
import com.sonht.model.User;


@WebServlet("/admin/customer")
public class CustomerController extends BaseController {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null) {
				command = "LIST";
			}
			switch (command) {
				case "LIST" -> listUsers(request, response);
				default -> loadUser(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// read the "command" parameter
			String command = request.getParameter("command");
//			System.out.println(command);
			// if the command is missing, then default to listing users
			if (command == null) {
				command = "LIST";
			}
			// route to the appropriate method
			switch (command) {
				case "ADD" -> addUser(request, response, command);
				case "UPDATE" -> updateUser(request, response, command);
				case "LOCK" -> lockUser(request, response);
				case "OPEN" -> openUser(request, response);
				case "DELETE" -> deleteUser(request, response);
				default -> listUsers(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	private void lockUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get id from form data modal lock
		String id = request.getParameter("userId");
		if (id != null) {
			getUserDAO().lockUser(id); 
			// send message to customer page
			request.setAttribute("messagesError", "success");
			// return to customer page
			listUsers(request, response); // return customer page
		} else {
			// send message to customer page
			request.setAttribute("messagesError", "fail");
			// return to customer page
			listUsers(request, response); // return customer page
		}
	}
	
	private void openUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get id from form data modal open
		String id = request.getParameter("userId");
		
		if (id != null) {
			getUserDAO().openUser(id); 
			// send message to customer page
			request.setAttribute("messagesError", "success");
			// return to customer page
			listUsers(request, response); // return customer page
		} else {
			// send message to customer page
			request.setAttribute("messagesError", "fail");
			// return to customer page
			listUsers(request, response); // return customer page
		}
		
	}

	
	private void updateUser(HttpServletRequest request, HttpServletResponse response, String command) throws Exception {
		// read user info from form data
		int id = Integer.parseInt(request.getParameter("userId"));
		String fullName = request.getParameter("fullnameUp");
		String phoneNumber = request.getParameter("phoneNumberUp");
		String address = request.getParameter("addressUp");
		int role = Integer.parseInt(request.getParameter("roleUp"));
		// create a new user object
		User user = new User(id, fullName, phoneNumber, address, role);
		List<String> messageErrors = validateUser(user, command);
		
		if (messageErrors.size() != 0) {
			request.setAttribute("messagesError", messageErrors); // send message fail to jsp
			listUsers(request, response); // return customer page

		} else {
			getUserDAO().updateStudent(user); // add new User into database
			request.setAttribute("messagesError", "success"); // send message success to jsp
			listUsers(request, response); // return customer page
		}
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response, String command) throws Exception {
		// Get data from form add User
		String fullName = request.getParameter("fullnameAdd");
		String email = request.getParameter("emailAdd");
		String phoneNumber = request.getParameter("phoneNumberAdd");
		String address = request.getParameter("addressAdd");
		String username = request.getParameter("usernameAdd");
		String password = request.getParameter("passwordAdd");
		String role = request.getParameter("roleAdd");
		// create a User
		User user = new User(username, password, fullName, email, phoneNumber, address, "active",
				Integer.parseInt(role));
		List<String> messageErrors = validateUser(user, command);
		
		if (messageErrors.size() != 0) {
			request.setAttribute("messagesError", messageErrors); // send message fail to jsp
			listUsers(request, response); // return customer page

		} else {
			getUserDAO().addUser(user); // add new User into database
			request.setAttribute("messagesError", "success"); // send message success to jsp
			listUsers(request, response); // return customer page
		}
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<User> listUsers = getUserDAO().getAllUsers();
		request.setAttribute("list_users", listUsers);
//		request.setAttribute("messagesError", null);
		request.getRequestDispatcher("/views/admin/pages/customer/manageCustomer.jsp").forward(request, response);
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get id from form data modal lock
		String id = request.getParameter("userId");
		if (id != null) {
			getUserDAO().deleteUser(id); 
			// send message to customer page
			request.setAttribute("messagesError", "success");
			// return to customer page
			listUsers(request, response); // return customer page
		} else {
			// send message to customer page
			request.setAttribute("messagesError", "fail");
			// return to customer page
			listUsers(request, response); // return customer page
		}
	}

	private void loadUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		// read user id from form data
		String userId = request.getParameter("userId");
//		System.out.println(userId);
		// get user from db
		User userFromDB = getUserDAO().getUserById(userId);
		// create JSON string convert object to JSON
		String json = new Gson().toJson(userFromDB);
		// return JSON data
		response.getWriter().write(json);

	}

	
}