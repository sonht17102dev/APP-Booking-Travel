package com.sonht.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.sonht.model.Tour;
import com.sonht.model.User;

/**
 * Servlet implementation class TourController
 */
@WebServlet("/admin/tour")
@MultipartConfig
public class TourController extends BaseController {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("commandTour");
			if (command == null) {
				command = "LIST";
			}
			switch (command) {
			case "LOAD" -> loadTour(request, response);
			default -> listTours(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("commandTour");
			if (command == null) {
				command = "LIST";
			}
			switch (command) {
			case "ADD" -> addTour(request, response);
			case "UPDATE" -> updateTour(request, response);
			case "DELETE" -> deleteTour(request, response);
			default -> listTours(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void listTours(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Tour> listTours = getTourDAO().getAllTours();
		request.setAttribute("list_tours", listTours);
		request.getRequestDispatcher("/views/admin/pages/tour/manageTour.jsp").forward(request, response);
	}

	protected void loadTour(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read tour id from form data
		String tourId = request.getParameter("tourId");
		// get tour from db
		Tour tourFromDB = getTourDAO().getTourById(tourId);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		// create JSON string convert object to JSON
		String json = new Gson().toJson(tourFromDB);
		// return JSON data
		response.getWriter().write(json);
	}

	protected void deleteTour(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String id = request.getParameter("tourId");
		if (id != null) {
			getTourDAO().deleteTour(id);
			// send message to tour page
			request.setAttribute("messagesSuccess", "DELETE");
			// return to tour page
			listTours(request, response); // return tour page
		} else {
			// send message to tour page
			request.setAttribute("messagesError", "Delete fail");
			// return to customer page
			listTours(request, response); // return tour page
		}
	}

	protected void updateTour(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		int id = Integer.parseInt(request.getParameter("tourId"));
		String tourName = request.getParameter("tournameUp");
		String priceUp = request.getParameter("priceUp");
		String start = request.getParameter("startDateUp");
		String duetime = request.getParameter("duetimeUp");
		String address = request.getParameter("addressUp");
		String content = request.getParameter("editorUp" + id);
//		System.out.println(content);
		Tour tour = null;
		if (isValidInput(priceUp))
			tour = new Tour( tourName, "", content, start, duetime, Double.parseDouble(priceUp), address, "active");
		else 
			tour = new Tour( tourName, "", content, start, duetime, 0, address, "active");
		
		List<String> messageErrors = validateTour(tour);

		Part filePart = request.getPart("fileUp"+ id);
//		System.out.println(filePart.getSize());
		String fileName = null;
		if(filePart == null || filePart.getSize() == 0) {
			messageErrors.add("Please select a file to upload.");
		} else {
			fileName = getFileName(filePart);
			try (InputStream fileContent = filePart.getInputStream();) {
				File uploads = new File(getServletContext().getRealPath("/resources/images"));
				if (!uploads.exists()) {
					uploads.mkdir();
				}

				File file = new File(uploads, fileName);
				Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (messageErrors.size() != 0) {
			request.setAttribute("messagesError", messageErrors); // send message fail to jsp
			listTours(request, response); // return customer page
		} else {
			tour.setImage(fileName);
			// send message to tour page
			request.setAttribute("messagesSuccess", "UPDATE");
			getTourDAO().updateTour(id, tour);
			listTours(request, response);
		}
	}

	protected void addTour(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		String tourName = request.getParameter("tournameAdd");
		String priceAdd = request.getParameter("priceAdd");
		String start = request.getParameter("startDateAdd");
		String duetime = request.getParameter("duetimeAdd");
		String address = request.getParameter("addressAdd");
		String content = request.getParameter("editor");
		String photoName = request.getParameter("filename");
		
		Tour tour = null;
		if (isValidInput(priceAdd))
			tour = new Tour( tourName, photoName, content, start, duetime, Double.parseDouble(priceAdd), address, "active");
		else 
			tour = new Tour( tourName, photoName, content, start, duetime, 0, address, "active");
		
		List<String> messageErrors = validateTour(tour);

		Part filePart = request.getPart("file");
		String fileName = null;
		if(filePart == null || filePart.getSize() == 0) {
			messageErrors.add("Please select a file to upload.");
		} else {
			fileName = getFileName(filePart);
			try (InputStream fileContent = filePart.getInputStream();) {
				File uploads = new File(getServletContext().getRealPath("/resources/images"));
				if (!uploads.exists()) {
					uploads.mkdir();
				}

				File file = new File(uploads, fileName);
				Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (messageErrors.size() != 0) {
			request.setAttribute("messagesError", messageErrors); // send message fail to jsp
			listTours(request, response); // return customer page
		} else {
			tour.setImage(fileName);
			// send message to tour page
			request.setAttribute("messagesSuccess", "ADD");
			getTourDAO().addTour(tour);
			listTours(request, response);
		}
	}
}