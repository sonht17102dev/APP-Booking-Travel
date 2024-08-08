package com.sonht.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sonht.model.Post;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/admin/post")
public class PostController extends BaseController {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("commandPost");
			if (command == null) {
				command = "LIST";
			}
			switch (command) {
			case "LOAD" -> loadPost(request, response);
			default -> listPosts(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String command = request.getParameter("commandPost");
			if (command == null) {
				command = "LIST";
			}
			switch (command) {
			case "ADD" -> addPost(request, response);
			case "UPDATE" -> updatePost(request, response);
			case "DELETE" -> deletePost(request, response);
			default -> listPosts(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void listPosts(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Post> listPosts = getPostDAO().getAllPosts();
		request.setAttribute("list_posts", listPosts);
		request.getRequestDispatcher("/views/admin/pages/post/managePost.jsp").forward(request, response);
	}

	private void loadPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read post id from form data
		String postId = request.getParameter("postId");
		// get post from db
		Post postFromDB = getPostDAO().getPostById(postId);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		// create JSON string convert object to JSON
		String json = new Gson().toJson(postFromDB);
		// return JSON data
		response.getWriter().write(json);
	}
	private void deletePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	private void updatePost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

	private void addPost(HttpServletRequest request, HttpServletResponse response) {
		String postName = request.getParameter("postnameAdd");
		String created = request.getParameter("createdDateAdd");
		String content = request.getParameter("editor");
		String photoName = request.getParameter("filename");
		
		
	}

}
