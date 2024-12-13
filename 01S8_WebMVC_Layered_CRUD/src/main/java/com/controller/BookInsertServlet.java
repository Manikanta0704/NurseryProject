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

public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	   
    public BookInsertServlet() {
        super();   
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		BookDao bookDao = new BookDao();
		Book book = new Book();
		int rows = 0;
		int id;
		String name, author;
		float price;
		
		id = Integer.parseInt(request.getParameter("id"));
		name = request.getParameter("name");
		author =  request.getParameter("author");
		price = Float.parseFloat(request.getParameter("price"));
		
		// make the pojo ready with data
		book.setBookId(id);
		book.setBname(name);
		book.setAuthor(author);
		book.setPrice(price);
		
		// pojo is ready with data
		System.out.println(book.getBname());
		try {
			rows = bookDao.insertBook(book);
		} catch (ClassNotFoundException e) {     
			
			e.printStackTrace();
		}
		if( rows == 1) {
			out.println("Book data successfully inserted "  );
			System.out.println("Book data successfully inserted");
		} else {
			System.out.println("Book data could not insert");	
		}
		RequestDispatcher reqDisp = request.getRequestDispatcher("/index.html");
	    reqDisp.forward(request, response);
	}
}
