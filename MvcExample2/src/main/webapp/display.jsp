<%@page import="com.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
<%@ include file="home.jsp" %>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-4">
    <h2 class="text-center mb-4">Student List</h2>
      <a href="home.jsp">home page</a>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>SID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Mobile</th>
                <th>Address</th>
                <th>Email</th>
                <th>Course</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<Student> al = (List<Student>) request.getAttribute("studentList");
            if (al != null && !al.isEmpty()) {
                for (Student s : al) { 
            %>
            <tr>
                <td><%= s.getSid() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getAge() %></td>
                <td><%= s.getMobile() %></td>
                <td><%= s.getAddress() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getCourse() %></td>
            </tr>
            <% 
                }
            } else { 
            %>
            <tr>
                <td colspan="7" class="text-center">No students found.</td>
            </tr>
            <% 
            } 
            %>
        </tbody>
    </table>
</div>
<!-- Bootstrap JS (optional for features like modals, dropdowns, etc.) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
