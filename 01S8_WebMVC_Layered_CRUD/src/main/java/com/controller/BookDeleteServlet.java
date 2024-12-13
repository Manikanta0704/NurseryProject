package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.pojo.Book;

public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookDeleteServlet() {
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookDao bookDao = new BookDao();
		Book book = new Book();
		int rows = 0;
		int id;
		String name, author;
		float price;

		id = Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		out.println("Book id " + id);
		try {
			rows = bookDao.deleteBook(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if( rows == 1) {
			System.out.println("Book data successfully deleted");
		}
		else {	
			System.out.println("Book data could not delete");
		}
		RequestDispatcher reqDisp = request.getRequestDispatcher("/index.html");
	    reqDisp.forward(request, response);
	}
}
