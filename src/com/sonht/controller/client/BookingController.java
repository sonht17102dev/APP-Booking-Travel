package com.sonht.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sonht.controller.admin.BaseController;
import com.sonht.dto.BookingDTO;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/booking")
public class BookingController extends BaseController {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<BookingDTO> listBookingsByUserId = getBookingDAO().getBookingsByUserId(1);
			request.setAttribute("listBookings", listBookingsByUserId);
			request.getRequestDispatcher("/views/client/booking.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
