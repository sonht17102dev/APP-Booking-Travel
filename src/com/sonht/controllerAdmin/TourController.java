package com.sonht.controllerAdmin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sonht.model.Tour;

/**
 * Servlet implementation class TourController
 */
@WebServlet("/TourController")
public class TourController extends BaseController {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null) {
				command = "LIST";
			}
			switch (command) {
				case "LIST" -> listTours(request, response);
				default -> loadTour(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			if (command == null) {
				command = "LIST";
			}
			switch (command) {
				case "ADD" -> addTour(request, response, command);
				case "UPDATE" -> updateTour(request, response, command);
				case "LOCK" -> lockTour(request, response);
				case "OPEN" -> openTour(request, response);
				case "DELETE" -> deleteTour(request, response);
				default -> listTours(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void listTours(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Tour> listTours = getTourDAO().getAllTours();
		request.setAttribute("list_tours", listTours);
		request.getRequestDispatcher("/views/admin/pages/customer/manageTour.jsp").forward(request, response);
	}
	



	private void loadTour(HttpServletRequest request, HttpServletResponse response) {
	}


	private void deleteTour(HttpServletRequest request, HttpServletResponse response) {
	}

	private void openTour(HttpServletRequest request, HttpServletResponse response) {
	}

	private void lockTour(HttpServletRequest request, HttpServletResponse response) {
	}

	private void updateTour(HttpServletRequest request, HttpServletResponse response, String command) {
	}

	private void addTour(HttpServletRequest request, HttpServletResponse response, String command) {
	}

}