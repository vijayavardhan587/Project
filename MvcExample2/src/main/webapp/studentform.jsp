<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>
    

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   
</head>
<body>

<div class="container mt-0">
    <h1 class="text-center mb-0">Student Form</h1>
     <% 
                        String errorMessage = (String) request.getAttribute("errorMessage");
                        String successMessage = (String) request.getAttribute("message");
                        if (errorMessage != null) { 
                    %>
                    <div class="alert alert-danger mt-3"><%= errorMessage %></div>
                    <% 
                        } else if (successMessage != null) { 
                    %>
                    <div class="alert alert-success mt-3"><%= successMessage %></div>
                    <% 
                        } 
                    %>
    <form action="savestudent" method="post">
     <a href="home.jsp">home page</a>
        <div class="form-group">
       
         <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="age">Age:</label>
            <input type="text" class="form-control" id="age" name="age">
        </div>
        <div class="form-group">
            <label for="mobile">Mobile:</label>
            <input type="tel" class="form-control" id="mobile" name="mobile">
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address" name="address">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>
        <div class="form-group">
            <label for="course">Course:</label>
            <input type="text" class="form-control" id="course" name="course">
        </div>
        <button type="submit" class="btn btn-primary">save</button>
    </form>
     
</div>

</body>
</html>
