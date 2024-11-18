<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    /* Style for the colored line */
    .underline {
        width: 50%;
        height: 4px;
        background-color: #007bff; /* Blue color */
        margin: 0 auto;
    }
</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Student Management</a>
          <a href="registration.jsp">register user</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <form action="studenthome" method="post" style="display: inline;">
                        <button type="submit" class="btn btn-primary m-1" name="action" value="addstudent">Add Student</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="studenthome" method="post" style="display: inline;">
                        <button type="submit" class="btn btn-secondary m-1" name="action" value="display">Display all student</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="studenthome" method="post" style="display: inline;">
                        <button type="submit" class="btn btn-success m-1" name="action" value="update">Update</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="studenthome" method="post" style="display: inline;">
                        <button type="submit" class="btn btn-danger m-1" name="action" value="delete">Delete</button>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-wEmeIV1mKuiNpZ8fE06qGxA2Qa35A5SMDgAR5Hsa1g7yxUstPiC8FfKOGa1pQa3F" crossorigin="anonymous"></script>
</body>
</html>
