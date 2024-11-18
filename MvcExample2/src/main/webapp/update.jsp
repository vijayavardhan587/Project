<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="home.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-4">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-2">
    <h1 class="text-center mb-4">Update Student Detail</h1>

    

    <div class="mb-3">
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

    
    <form action="showstudentdatatoupdate" method="post">
        <div class="form-group">
            <label for="email">enter email:</label>
            <input type="email" class="form-control" style="width:400px;" name="email" id="email" required>
        </div>
        <button type="submit" class="btn btn-primary">next ></button>
        <a href="home.jsp" class="btn btn-secondary">Home Page</a>
    </form>
</div>



</body>
</html>
