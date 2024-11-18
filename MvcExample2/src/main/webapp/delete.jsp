<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="home.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Student</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<div class="container mt-4">
    <h2 class="text-center mb-4">Delete Student</h2>

    
    <form action="deletestudentdata" method="post">
        <div class="form-group">
            <label for="mobile">Enter Mobile Number:</label>
            <input type="number" class="form-control" name="mobile" id="mobile" required>
        </div>
        
        <button type="submit" class="btn btn-danger">Delete</button>
        <a href="home.jsp" class="btn btn-secondary">Home Page</a>
    </form>

    <!-- Display messages -->
    <div class="mt-3">
        <% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            String errorMesg = (String) request.getAttribute("errorMesg");
            String successMessage = (String) request.getAttribute("message");

            if (errorMessage != null) { 
        %>
            <div class="alert alert-danger"><%= errorMessage %></div>
        <% 
            } else if (errorMesg != null) { 
        %>
            <div class="alert alert-danger"><%= errorMesg %></div>
        <% 
            } else if (successMessage != null) { 
        %>
            <div class="alert alert-success"><%= successMessage %></div>
        <% 
            }
        %>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
