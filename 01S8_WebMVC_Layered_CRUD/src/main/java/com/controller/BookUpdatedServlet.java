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

public class BookUpdatedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		BookDao bookDao = new BookDao();
		Book book = new Book();
		int rows = 0;
		int id;

		id = Integer.parseInt(request.getParameter("id"));
		try {
			rows = bookDao.updateBook(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if( rows == 1) {
			out.println("Book data successfully inserted "  );
			System.out.println("Book data successfully updated");
		} else {
			System.out.println("Book data could not update");

		}
		RequestDispatcher reqDisp = request.getRequestDispatcher("/index.html");
	    reqDisp.forward(request, response);
	}
	
}