<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="home.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-4">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-2">
    <h1 class="text-center mb-4">Update Student Detail</h1>

    <!-- Display messages -->
    <div class="mb-3">
        <%


            String message = (String) request.getAttribute("Message");
            if (message != null) {
        %>
            <div class="alert alert-info text-center"><%= message %></div>
        <% 
            }
        %>
<form action="updatestudentdata" method="post">
        
        <input type="hidden" name="email" value="<%= request.getAttribute("email") %>">

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" name="name" id="name" required>
        </div>

        <div class="form-group">
            <label for="age">Age:</label>
            <input type="number" class="form-control" name="age" id="age" required>
        </div>

        <div class="form-group">
            <label for="mobile">Mobile:</label>
            <input type="tel" class="form-control" name="mobile" id="mobile" required>
        </div>

        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" name="address" id="address" required>
        </div>

        <div class="form-group">
            <label for="course">Course:</label>
            <input type="text" class="form-control" name="course" id="course" required>
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
        <a href="home.jsp" class="btn btn-secondary">Home Page</a>
    </form>

</div>

</body>
</html>
