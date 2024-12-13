package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.helper.ConnectToDB;
import com.pojo.Book;

public class BookDao {
	// JDBC API classes for data retrieval
		private Connection connection = null;
		private PreparedStatement statement = null;
		private ResultSet resultSet = null;

//		Book book = new Book();
		ArrayList<Book> bookList = new ArrayList<Book>();
		private static String bookQry = "select * from book";

		public ArrayList getBooks() throws ClassNotFoundException, SQLException {
			try {
				connection = ConnectToDB.createConnection();
				statement = connection.prepareStatement(bookQry);
				resultSet = statement.executeQuery();
				
				while (resultSet.next()) {
					int bookId;
					String bookName;
					String author;
					float price;
					// declare the pojo
					Book book = new Book();
					// get the row details
					bookId = resultSet.getInt(1);
					bookName = resultSet.getString(2);
					author = resultSet.getString(3);
					price = resultSet.getFloat(4);
					// set the pojo with retrieved values from the row
					
					book.setBookId(bookId);
					book.setBname( bookName );
					book.setAuthor( author );
					book.setPrice( price );
					// add the book to booklist
					bookList.add(book);

				} // end of while loop

			} catch (SQLException sqlex) {
				sqlex.printStackTrace();
			} finally {
				// close connection
				// now data is in array list object no need to keep the connection opened
				//ConnectToDB.closeConnection();
			}
			return bookList;
		} // end of getBooks() method

		public int insertBook(Book book) throws ClassNotFoundException {
			int rows = 0;
			try {
				connection = ConnectToDB.createConnection();
				System.out.println("Connection object - " + connection);
				PreparedStatement pstmt = connection.prepareStatement("insert into book values( ?,?,?,?)"); 
				pstmt.setInt( 1, book.getBookId() );
				pstmt.setString( 2, book.getBname() );
				pstmt.setString( 3, book.getAuthor() );
				pstmt.setFloat( 4, book.getPrice() );
				rows = pstmt.executeUpdate();
				
				connection.setAutoCommit(false);
				connection.commit();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return rows;
		}

		// update book
		public int updateBook(int id) throws ClassNotFoundException {
		    int rows = 0;
		    try (Connection connection = ConnectToDB.createConnection();
		         PreparedStatement pstmt = connection.prepareStatement("UPDATE book SET price = price + price * 0.25 WHERE bookId = ?")) {

		        pstmt.setInt(1, id);
		        rows = pstmt.executeUpdate();
		        connection.commit();
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		    return rows;
		}

//		delete book
		
		public int deleteBook(int id) throws ClassNotFoundException, SQLException {
			int rows = 0;
			connection = ConnectToDB.createConnection();
			try {
				PreparedStatement pstmt = connection.prepareStatement("delete from book where bookid=?");
				pstmt.setInt(1, id);
				rows = pstmt.executeUpdate();
				//connection.commit();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return rows;
		}


}
