<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.pojo.Book" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Page</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        h3 {
            text-align: center;
        }
        p {
            text-align: center;
            font-weight: bold;
            color: red;
        }
    </style>
</head>
<body>
    <h3>View All Books</h3>
    <%
        // Retrieve the book list from the request scope
        ArrayList<Book> bookList = (ArrayList<Book>) request.getAttribute("booklist");

        if (bookList == null || bookList.isEmpty()) {
    %>
        <p>No books available.</p>
    <%
        } else {
    %>
        <table>
            <thead>
                <tr>
                    <th>Book ID</th>
                    <th>Book Name</th>
                    <th>Author</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <% for (Book book : bookList) { %>
                <tr>
                    <td><%= book.getBookId() %></td>
                    <td><%= book.getBname() %></td>
                    <td><%= book.getAuthor() %></td>
                    <td><%= book.getPrice() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    <%
        }
    %>
</body>
</html>
