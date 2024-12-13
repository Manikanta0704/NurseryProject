package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.BookDao;
import com.pojo.Book;


public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookServlet() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Book> bookList = new ArrayList<>();
	    BookDao bookDao = new BookDao();

	    try {
	        bookList = bookDao.getBooks();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	    }

	    // Attach the book list to the request scope
	    request.setAttribute("booklist", bookList);

	    // Forward to JSP
	    RequestDispatcher reqDisp = request.getRequestDispatcher("/showBookDetails.jsp");
	    reqDisp.forward(request, response);
	}
}

