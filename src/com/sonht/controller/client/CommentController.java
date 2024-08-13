package com.sonht.controller.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sonht.controller.admin.BaseController;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/comment")
public class CommentController extends BaseController {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String postId = request.getParameter("postId");
		String message = request.getParameter("comment");
		String[] rates = request.getParameterValues("rate");
//		System.out.println(userId);
//		System.out.println(postId);
//		System.out.println(message);
//		if(rates != null) {
//			for(String s : rates) {
//				System.out.println(s);
//			}
//		}
		
	}

}
