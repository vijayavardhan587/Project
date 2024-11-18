package com.tech.palle.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Project name= JDBC console project
//Description: the main purpose of this project is it explore JDBC APIS for performing DML operations

public class JDBCProject {
public static int count=1;
	public static void main(String[] args) {
//		call creating function - so that it create table
		Dao d= new Dao();
		/*
		 * lets ask user for input...
		 */
		Scanner sc= new Scanner(System.in);
		int option =0;
		System.out.println("\n------JDBC CONSLOE PROJECT WELCOME YOU----\n");
		do {
			System.out.println("----CHOOSE CORRECT OPTION");
			System.out.println("1 : creating a table");
			System.out.println("2 : inserting into table");
			System.out.println("3 : updating a row of table");
			System.out.println("4 : delect a row of table");
			System.out.println("5 : read one row");
			System.out.println("6 : read all rows");
			System.out.println("0 : exit");
			option=sc.nextInt();// what ever user enter that foes to option variable
			switch(option) {
			case 1:
				if(count==1)
				{
					d.creating();  //in this case we are creating a table
					count++;
				}
				else
				{
					System.out.println("YOU CANT CREATE TABLE MULTIPLE TIMES");
				}
				break;
			case 2:
				System.out.println("enter eno,ename,esalary sequentially");
				int enumber=sc.nextInt();
				sc.nextLine();
				String ename=sc.nextLine();
				int esalary=sc.nextInt();
				d.inserting(enumber, ename, esalary); //in this case we are inserting values into emp table
				break;
			case 3:
				//we have to read eno and esalary from salary
				System.out.println("enter eno and new salary");
				int enumber1=sc.nextInt();
				int newsalary=sc.nextInt();
				d.updating(enumber1, newsalary); //in this case we are updating salary based on enumber
				                                 //taking eno and new salary from keyboard
				break;
			case 4:
				System.out.println("enter enumber");
				int enumber2=sc.nextInt();
				d.Deleting(enumber2); //in this case we are deleting a record based on enumber
				break;
			case 5:
				d.Display(); //in this case we are displaying all the emp table data
				break;
			case 6:
				System.out.println("enter enumber");
				int enumber3=sc.nextInt();
				d.displaySingleRow(enumber3); //in this case we are reading single row based on enumber
				break;

			case 0:
				System.out.println("OK I AM EXITING");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return;
			}
		}while(option !=0);
	
		
//		d.creating();
//		d.inserting(1, "Viajy", 54000);//this will insert first employee
//		d.inserting(2, "nandu", 45000);//this will insert first employee
//		d.updating(1, 60000);//this will update 1st emp salary to 60000
//        d.inserting(3, "tarak", 900000);
//		d.Deleting(3);
//		d.Display();
//		d.displaySingleRow(1);
	}

}
// let us take another class for JDBC code
//class name : DAO - data access object  - DAO layout
//               In this class we are going to write code for 5 operations
class Dao
{
//	in this method we will create employee table
	public void creating()
	{
		Statement s=null;
		Connection c=null;
		try {
//			loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			Establish connection
			 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Vijay@54");
			 
//			 prepare SQL Statement
			 s= c.createStatement();
			 
//			 s.execute query
			s.executeUpdate("create table employee(eno int primary key,ename varchar(40),esalary int);");
			System.out.println("TABLE CREATE SUCCESSFULLY...");
		
		}
		catch (ClassNotFoundException e) {
			System.out.println("DRIVE IS NOT PROPERLY LOADED");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONGA WITH DATABASE");
			e.printStackTrace();
		}finally {
			if(s!=null)
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(c!=null)
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
//	in below method we will insert data into employee table
	public void inserting(int eno,String ename ,int esal) {
//		PreparedStatement means since we are getting Dynamic values
		PreparedStatement s= null;
		Connection c= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Vijay@54");
			
			String query="insert into employee values(?,?,?)";
			s=c.prepareStatement(query);
			s.setInt(1, eno);
			s.setString(2, ename);
			s.setInt(3, esal);
			s.executeUpdate();
			System.out.println("SUCCESSFULLY INSERT A ROW...");
			
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER IS NOT LOADED PROPERLY");
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG WITH DATABASE");
			e.printStackTrace();
		}catch(Exception e) {
//			if some unknown exception occurs this catch block will execute
			System.out.println("SOMETHING UNUSAL THING HAPPEND");
		}finally {
			if(s!=null)
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(c!=null)
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
// in below method we will update.. for a given eno update new salary
	public void updating(int eno,int newsal)
	{
	Connection c=null;
	PreparedStatement s=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Vijay@54");
		String query ="update employee set esalary=? where eno=?";
		s= c.prepareStatement(query);
		s.setInt(1, newsal);
		s.setInt(2, eno);
		s.executeUpdate();
		System.out.println("RECORD UPDATE SUCCESSFULLY");
	} catch (ClassNotFoundException e) {
		System.out.println("DRIVER IS NOT LOADED PROPERLY");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("SOMTHING WRONG WITH SQL CONNECTION");
		e.printStackTrace();
	}finally {
		if(s!=null) {
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(c!=null)
		{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
  }
//   in below method we will delete from employee based on eno
	public void Deleting(int eno)
	{
		Connection c= null;
		PreparedStatement s= null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Vijay@54");
			String query="delete from employee where eno=?";
			s=c.prepareStatement(query);
			s.setInt(1, eno);
			s.executeUpdate();
			System.out.println("delete employee number");
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER IS NOT LOADED PROPERLY");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SOMTHING WRONG WITH SQL CONNECTION");
			e.printStackTrace();
		}finally
		{
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
// in below method display the value
	public void Display()
	{
		Connection c= null;
		Statement s= null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Vijay@54");
			s=c.createStatement();
			ResultSet res = s.executeQuery("select * from employee");
			System.out.println("\n-----EMPLOYEE TABLE DATA BELOW----\n");
			System.out.println("eno      ename      esalary");
			System.out.println("----    -------     -------");
			while(res.next())
			{
				System.out.println(res.getInt(1)+"       "+res.getString(2)+"        "+res.getInt(3));
			}
			System.out.println("---------------------------------------");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

public void displaySingleRow(int eno)
{
	Connection c= null;
	PreparedStatement s=null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Vijay@54");
		String query="select * from employee where eno=?";
		s=c.prepareStatement(query);
		s.setInt(1, eno);
		ResultSet res= s.executeQuery();
		if(res.next())
		{
			System.out.println(res.getInt(1)+"     "+res.getString(2)+"     "+res.getString(3));
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if(s!=null)
		{
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(c!=null)
		{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
}


