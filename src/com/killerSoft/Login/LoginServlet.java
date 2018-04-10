package com.killerSoft.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
 
 

public class LoginServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 String id = "";
 String Userpassword = "";
 Connection connection = null;
 Statement querySmt = null;
 ResultSet result = null;
 UserBean user = null;
 Object obj[] = null;
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 // TODO Auto-generated method stub
 }
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
 
 String user_id = request.getParameter("id").trim();
 String password = request.getParameter("password").trim();
 //Database operations using JDBC
 System.out.print(user_id+" "+password);
 
 Session session =null;
 try{
 //Hibernate Call
 Configuration configuration = new Configuration();
 configuration.configure("hibernate.cfg.xml");
 
 StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings( configuration.getProperties());
 SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
 session = sessionFactory.openSession();
 if( session.isConnected())
 {
 user = (UserBean)session.load(UserBean.class, Long.parseLong(user_id));
 }
 else 
 {
 System.out.println("Connection faiied");
 }
 }
 catch (HibernateException e)
 {
 e.printStackTrace();
 } 
 //Database operations completed
 System.out.println("User ID is " + user.getUser_id()+" "+user_id);
 System.out.println("User password is " + user.getUser_password()+" "+password);
 System.out.println("User status is " + user.getUser_status());
 if(user_id.equals(new Long(user.getUser_id()).toString()) && password.equals(user.getUser_password()))
 {
 System.out.println("hi");
 RequestDispatcher rdp = request.getRequestDispatcher("/index.jsp");
 rdp.forward(request, response);
 }
 else
 { 
 request.getRequestDispatcher("/fail.jsp").forward(request, response);
 }
 }
}