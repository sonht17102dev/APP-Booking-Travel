package com.sonht.controllerAdmin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.sonht.dao.BookingDAO;
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
	protected static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	protected static final String PHONE_REGEX = "^\\+?[0-9]{10,15}$";
	protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public UserDAO getUserDAO() {
		return new UserDAO();
	}

	public TourDAO getTourDAO() {
		return new TourDAO();
	}

	public BookingDAO getBookingDAO() {
		return new BookingDAO();
	}

	public List<String> validateTour(Tour tour) {
		List<String> messagesError = new ArrayList<String>();
		List<String> errors = validateTripDates(tour.getStartDate(), tour.getDuetime());
		if (!errors.isEmpty()) {
			messagesError.addAll(errors);
		}
		if (!isValidFullname(tour.getName())) {
			messagesError.add("Tour Name is required!");
		}
		if (tour.getPrice() == 0) {
			messagesError.add("Tour Price is required!");
		}

		if (!isValidAddress(tour.getAddress())) {
			messagesError.add("Tour address is required!");
		}
		if (!isValidDescription(tour.getDescription())) {
			messagesError.add("Description is required!");
		}

		return messagesError;
	}

	public static List<String> validateTripDates(String startDateStr, String endDateStr) {
		List<String> results = new ArrayList<String>();
		
		if ((startDateStr == null || startDateStr.trim().isEmpty()) && (endDateStr == null || endDateStr.trim().isEmpty())) {
			results.add("Start date cannot be empty.");
			results.add("End date cannot be empty.");
			return results;
		}
		if (startDateStr == null || startDateStr.trim().isEmpty()) {
			results.add("Start date cannot be empty.");
			return results;
		}

		if (endDateStr == null || endDateStr.trim().isEmpty()) {
			results.add("End date cannot be empty.");
			return results;
		}

		LocalDate startDate;
		LocalDate endDate;
		LocalDate currentDate = LocalDate.now();

		try {
			startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
		} catch (DateTimeParseException e) {
			results.add("Invalid start date format. Please use yyyy-MM-dd.");
			return results;
		}

		try {
			endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);
		} catch (DateTimeParseException e) {
			results.add("Invalid end date format. Please use yyyy-MM-dd.");
			return results;
		}

		if (startDate.isBefore(currentDate)) {
			results.add("Start date must be after the current date.");
			return results;
		}

		if (endDate.isBefore(startDate) || endDate.equals(startDate)) {
			results.add("End date must be after the start date.");
			return results;
		}

		return results;
	}
//	public static Map<Boolean, String> validateTripDates(String startDateStr, String endDateStr) {
//		Map<Boolean, String> map = new HashMap<Boolean, String>();
//
//		if (startDateStr == null || !map.containsValue("Start date cannot be empty.")) {
//    		map.put(false, "Start date cannot be empty.");
//        }
//
//        if (endDateStr == null || !map.containsValue("End date cannot be empty.")) {
//    		map.put(false, "End date cannot be empty.");
//        }
//        LocalDate startDate = null;
//        LocalDate endDate = null;
//        LocalDate currentDate = LocalDate.now();
//
//        try {
//            startDate = LocalDate.parse(startDateStr, DATE_FORMATTER);
//        } catch (DateTimeParseException e) {
////            System.out.println("Invalid start date format. Please use yyyy-MM-dd.");
////            return false;
//        	if (!map.containsValue("Invalid start date format. Please use yyyy-MM-dd."))
//        		map.put(false, "Invalid start date format. Please use yyyy-MM-dd.");
//        }
//
//        try {
//            endDate = LocalDate.parse(endDateStr, DATE_FORMATTER);
//        } catch (DateTimeParseException e) {
////            System.out.println("Invalid end date format. Please use yyyy-MM-dd.");
////            return false;
//        	if (!map.containsValue("Invalid start date format. Please use yyyy-MM-dd."))
//        		map.put(false, "Invalid start date format. Please use yyyy-MM-dd.");
//        }
//        
//        if (startDate != null && startDate.isBefore(currentDate) && !map.containsValue("Start date must be after the current date.")){
//        		map.put(false, "Start date must be after the current date.");
//        }
//
//        if (endDate != null && endDate.isBefore(startDate) && !map.containsValue("End date must be after the start date.")) {
//        		map.put(false, "End date must be after the start date.");
//        }
//
//        return map;
//    }

	public List<String> validateUser(User user, String command) {
		List<String> messagesError = new ArrayList<>();

		if (!isValidFullname(user.getFullname())) {
			messagesError.add("Please type your full name");
		}
		if (command.equals("ADD") && !isValidEmail(user.getEmail())) {
			messagesError.add("Please type your email or type invalid email");
		}
		if (!isValidPhoneNumber(user.getPhoneNumber())) {
			messagesError.add("Please type your phone number or phone number must have 10 digits");
		}
		if (!isValidAddress(user.getAddress())) {
			messagesError.add("Please type your address");
		}
		if (command.equals("ADD") && !isValidUsername(user.getUsername())) {
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

	public boolean isValidFullname(String fullname) {
		return fullname != null && !fullname.isEmpty();
	}

	public boolean isValidDescription(String description) {
		return description != null && !description.isEmpty();
	}

	public boolean isValidPrice(String price) {
		return price != null && !price.isEmpty();
	}

	public boolean isValidEmail(String email) {
		return email != null && !email.trim().isEmpty() && email.matches(EMAIL_REGEX);
	}

	public boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber != null && !phoneNumber.trim().isEmpty() && phoneNumber.matches(PHONE_REGEX);
	}

	public boolean isValidAddress(String address) {
		return address != null && !address.trim().isEmpty();
	}

	public boolean isValidUsername(String username) {
		return username != null && !username.trim().isEmpty();
	}

	public boolean isValidPassword(String password) {
		return password != null && !password.trim().isEmpty();
	}

}