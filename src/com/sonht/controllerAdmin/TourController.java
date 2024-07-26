package com.sonht.controllerAdmin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sonht.model.Tour;

/**
 * Servlet implementation class TourController
 */
@WebServlet("/admin/tour")
@MultipartConfig
public class TourController extends BaseController {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("commandTour");
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
			String command = request.getParameter("commandTour");
			System.out.println(command);
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
	protected void listTours(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Tour> listTours = getTourDAO().getAllTours();
		request.setAttribute("list_tours", listTours);
		request.getRequestDispatcher("/views/admin/pages/tour/manageTour.jsp").forward(request, response);
	}
	



	protected void loadTour(HttpServletRequest request, HttpServletResponse response) {
	}


	protected void deleteTour(HttpServletRequest request, HttpServletResponse response) {
	}


	protected void updateTour(HttpServletRequest request, HttpServletResponse response) {
	}

	protected void addTour(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tourName = request.getParameter("tournameAdd");
		double priceAdd = Double.parseDouble(request.getParameter("priceAdd"));
		String start = request.getParameter("startDateAdd");
		String duetime = request.getParameter("duetimeAdd");
		String address = request.getParameter("addressAdd");
//		String image = request.getParameter("imageAdd");
		String content = request.getParameter("editor");
		
		Part filePart = request.getPart("file");
		String fileName = getFileName(filePart);
		try (InputStream fileContent = filePart.getInputStream();) {
			File uploads = new File(getServletContext().getRealPath("/resources/images"));
			if(!uploads.exists()) {
				uploads.mkdir();
			}
			
			File file = new File(uploads, fileName);
			Files.copy(fileContent, file.toPath());
			Tour tour = new Tour(tourName, fileName, content, start, duetime, priceAdd, address, "active");
			System.out.println(tour);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}