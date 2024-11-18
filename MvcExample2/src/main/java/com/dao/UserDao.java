package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;
import com.bean.User;

public class UserDao {
	Connection con = null;
	Statement st = null;
	PreparedStatement ps = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/palle";

	String user = "root";
	String password = "Vijay@54";

	ResultSet rs = null;

	public boolean insertUser(User u) {
		boolean userdata = true;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement("insert into User (name,email,password,mobile) value(?,?,?,?)");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			while (rs.next()) {
				String Email = rs.getString("Email");
				String mobile = rs.getString("mobile");
				if (u.getEmail().equals(rs.getString("email")) && u.getmobile().equals(rs.getString("mobile"))) {
					userdata = false;
					break;
				}

			}
			if (userdata == true) {
				ps.setString(1, u.getName());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getPassword());
				ps.setString(4, u.getmobile());
				ps.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null || con != null) {
					st.close();
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userdata;
	}

	public boolean validateUser(User u) {
		boolean tableData = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from user");
			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("password");
				if (u.getEmail().equals(rs.getString("email")) && u.getPassword().equals(rs.getString("password"))) {
					tableData = true;
					break;
				}
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null || con != null) {
					st.close();
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tableData;
	}

	public boolean inserStudent(Student s) {
		boolean ispresent = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement("insert into student (name,age,mobile,address,email,course) value(?,?,?,?,?,?)");
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student");
			while (rs.next()) {
				String Email = rs.getString("Email");
				String mobile = rs.getString("mobile");
				if (s.getEmail().equals(rs.getString("email")) || s.getMobile().equals(rs.getString("mobile"))) {
					ispresent = true;
					break;
				}

			}
			if (!ispresent) {
				ps.setString(1, s.getName());
				ps.setInt(2, s.getAge());
				ps.setString(3, s.getMobile());
				ps.setString(4, s.getAddress());
				ps.setString(5, s.getEmail());
				ps.setString(6, s.getCourse());
				ps.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null || con != null) {
					st.close();
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ispresent;
	}

	public List<Student> getData() {
		List<Student> list = new ArrayList<Student>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student");
			while (rs.next()) {
				int sid = rs.getInt("sid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String course = rs.getString("course");
				Student s = new Student(sid, name, age, mobile, address, email, course);
				list.add(s);
			}

		} catch (ClassNotFoundException e) {


			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public boolean deleteStudent(Student s) {
		boolean studentdata = false;
		try {

			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);

			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM student");

			while (rs.next()) {
				String mobile = rs.getString("mobile");

				if (s.getMobile().equals(mobile)) {
					studentdata = true;

					ps = con.prepareStatement("DELETE FROM student WHERE mobile = ?");
					ps.setString(1, mobile);
					ps.executeUpdate();
					break;
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return studentdata;
	}

	public boolean studentExist(Student s) {
		boolean tableData = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from student");
			while (rs.next()) {
				String email = rs.getString("email");
				if (s.getEmail().equals(rs.getString("email"))) {
					tableData = true;
					break;
				}
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (st != null || con != null) {
					st.close();
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tableData;
	}
	
	public boolean updateStudent(Student s) {
		boolean updateStu = true;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			String updateQuery = "update student set name = ?, age = ?, mobile = ?,address = ?, course = ? where email = ?";
			ps = con.prepareStatement(updateQuery);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setString(3, s.getMobile());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getCourse());
            ps.setString(6, s.getEmail());
            ps.executeUpdate();
            updateStu=true;


          } catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return updateStu;
	}

}
