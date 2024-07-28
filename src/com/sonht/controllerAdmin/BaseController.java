package com.sonht.controllerAdmin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.sonht.dao.TourDAO;
import com.sonht.dao.UserDAO;
import com.sonht.model.Tour;
import com.sonht.model.User;

/**
 * Servlet implementation class BaseController
 */
@WebServlet("/BaseController")
public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final String EMAIL_REGEX= "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    protected static final String PHONE_REGEX= "^\\+?[0-9]{10,15}$";
    
	public UserDAO getUserDAO() {
		return new UserDAO();
	}
	
	public TourDAO getTourDAO() {
		return new TourDAO();
	}
	
	public Tour validateTour(Tour tour) {
		return tour;
	}
	public List<String> validateUser(User user, String command) {
	    List<String> messagesError = new ArrayList<>();

	    if (!isValidFullname(user.getFullname())) {
	        messagesError.add("Please type your full name");
	    }
	    if (!isValidEmail(user.getEmail())) {
	        messagesError.add("Please type your email or type invalid email");
	    }
	    if (!isValidPhoneNumber(user.getPhoneNumber())) {
	        messagesError.add("Please type your phone number or phone number must have 10 digits");
	    }
	    if (!isValidAddress(user.getAddress())) {
	        messagesError.add("Please type your address");
	    }
	    if (!isValidUsername(user.getUsername())) {
	        messagesError.add("Please type your username");
	    }
	    if (command.equals("ADD") && !isValidPassword(user.getPassword())) {
	        messagesError.add("Please type your password");
	    }
	    if (user.getRoleId() == -1) {
	        messagesError.add("Please choose your role (Admin or User)");
	    }

	    return messagesError;
	}

	private boolean isValidFullname(String fullname) {
	    return fullname != null && !fullname.isEmpty();
	}

	private boolean isValidEmail(String email) {
	    return email != null && !email.trim().isEmpty() && email.matches(EMAIL_REGEX);
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
	    return phoneNumber != null && !phoneNumber.trim().isEmpty() && phoneNumber.matches(PHONE_REGEX);
	}

	private boolean isValidAddress(String address) {
	    return address != null && !address.trim().isEmpty();
	}

	private boolean isValidUsername(String username) {
	    return username != null && !username.trim().isEmpty();
	}

	private boolean isValidPassword(String password) {
	    return password != null && !password.trim().isEmpty();
	}

}