<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center bg-primary text-white">
                    <h2>Login</h2>
                </div>
                <div class="card-body">
                    <form action="login" method="post">
                        <div class="mb-3">
                            <label for="email" class="form-label">User ID:</label>
                            <input type="text" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password:</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                        <div class="mt-3 text-center">
                            <a href="registration.jsp">Don't have an account? Sign up here</a>
                            
                        </div>
                    </form>
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
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-qLhf5uQ3yt7I6udZoEM65QqF3leWX/7P5sKwz7CX+EZZ55+Ghnoz9N4oFswI39Cx" crossorigin="anonymous"></script>
</body>
</html>
