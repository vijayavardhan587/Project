package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.bean.User;

import com.dao.UserDao;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();
		switch (path) {
		case "/reg":
			registration(request, response);
			break;
		case "/login":
			validateUser(request, response);
			break;
		case "/signup":
			signup(request, response);
			break;

		case "/studenthome":
			String action = request.getParameter("action");
			switch (action) {
			case "addstudent":
				addstudent(request, response);
				break;
			case "display":
				displayStudentData(request, response);
				break;
			case "update":updateStudent(request,response);
				break;
			case "delete":deleteStudent(request,response);
				break;
			}

			break;
		case "/savestudent":
			saveStudentDetails(request, response);
			break;
		case "/deletestudentdata":
			deleteStudentDetails(request, response);
			break;
		case "/showstudentdatatoupdate":
			showstudentdatatoupdate(request, response);
			break;
		case "/updatestudentdata":
			updateStudentData(request, response);
			break;
		}
	}

	private void updateStudentData(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		
		Student s  = new Student(name, age, mobile, address, email, course);
		UserDao ud = new UserDao();
		boolean isUpdated = ud.updateStudent(s);

	    if (isUpdated) {
	        request.setAttribute("Message", "Student details have been successfully updated.");
	    } else {
	        request.setAttribute("Message", "Failed to update student details. Please try again.");
	    }

	    RequestDispatcher rd = request.getRequestDispatcher("updateStudentData.jsp");
	    try {
	        rd.forward(request, response);
	    } catch (ServletException | IOException e) {
	        e.printStackTrace();
	    }
	
		}
		

		

	private void showstudentdatatoupdate(HttpServletRequest request, HttpServletResponse response) {
	    String email = request.getParameter("email");

	    if (email == null || email.trim().isEmpty()) {
	        request.setAttribute("errorMessage", "Student email is required");
	        try {
	            RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
	            rd.forward(request, response);  

	        } catch (ServletException | IOException e) {
	            e.printStackTrace();
	        }
	        return;
	    }

	    Student s = new Student();
	    s.setEmail(email);
	    UserDao ud = new UserDao();
	    boolean ispresent = ud.studentExist(s);

	    try {
	        if (ispresent) {
	        	request.setAttribute("email", email);
	        	RequestDispatcher rd = request.getRequestDispatcher("updateStudentData.jsp");
	        	rd.forward(request, response);
	        } else {


	            request.setAttribute("errorMesg", "Student with email " + email + " does not exist.");
	            RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
	            rd.forward(request, response);
	        }
	    } catch (IOException | ServletException e) {
	        e.printStackTrace();
	    }
	}

		
	

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("update.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
		

	private void deleteStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		String mobile= request.getParameter("mobile");
      if (mobile == null || mobile.trim().isEmpty()) {
		    request.setAttribute("errorMessage", "Mobile number is required");
		    RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
		    try {
		        rd.forward(request, response);
		    } catch (ServletException | IOException e) {
		        e.printStackTrace();
		    }
		    return;
		}
		
		
		
		
	    Student s = new Student(mobile);
		UserDao u=new UserDao();
		boolean ispresent=  u.deleteStudent(s);

		if (ispresent) { 

		    request.setAttribute("message", "student details has been deleted.");
		} else {

		    request.setAttribute("errorMesg", "student " + mobile + " does not exist.");
		}
		RequestDispatcher r = request.getRequestDispatcher("delete.jsp");
		try {
			r.forward(request, response);
		} catch (ServletException e) {


			e.printStackTrace();
		} catch (IOException e) {


			e.printStackTrace();
		}

				
	    }
	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			response.sendRedirect("delete.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	private void displayStudentData(HttpServletRequest request, HttpServletResponse response) {

		UserDao ud = new UserDao();
		List<Student> list = ud.getData();
		request.setAttribute("studentList", list);
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	private void saveStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String course = request.getParameter("course");
		Student s = new Student(name, age, mobile, address, email, course);
		s.setEmail(email);
		s.setMobile(mobile);
		UserDao ud = new UserDao();
		boolean isudatapresent = ud.inserStudent(s);

		try {
			if (isudatapresent) {
				request.setAttribute("errorMessage", "student already  exist");
				RequestDispatcher rd = request.getRequestDispatcher("studentform.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("message", "student  successfuly register");
				RequestDispatcher rd = request.getRequestDispatcher("studentform.jsp");
				rd.forward(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void addstudent(HttpServletRequest request, HttpServletResponse response) {

		try {
			response.sendRedirect("studentform.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void signup(HttpServletRequest request, HttpServletResponse response) {

		try {
			response.sendRedirect("registration.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void validateUser(HttpServletRequest request, HttpServletResponse response) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User u = new User(email, password);
		u.setEmail(email);
		u.setPassword(password);
		UserDao m = new UserDao();
		boolean isDataPresent = m.validateUser(u);

		try {
			if (isDataPresent) {
				request.setAttribute("message", "Login successful");
				response.sendRedirect("home.jsp");
			} else {
				request.setAttribute("errorMessage", "User does not exist");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void registration(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");

		User u = new User(name, email, password, mobile);
		UserDao ud = new UserDao();
		boolean userdata = ud.insertUser(u);

		try {
			if (userdata) {

				request.setAttribute("message", "Registration successful Please log in.");

				response.sendRedirect("login.jsp");
			} else {
				request.setAttribute("errorMessage", "User " + email + " already exists");
				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				rd.forward(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
