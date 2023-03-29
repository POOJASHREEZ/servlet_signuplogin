package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserInfo;



@WebServlet("/Login")
public class Login  extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String emph=req.getParameter("emph");
	String password=req.getParameter("pwd");
	
	UserDao dao=new UserDao();
	PrintWriter out=resp.getWriter();
	List<UserInfo> list=dao.fetchAll();
	
	try{
       long mobile=Long.parseLong(emph);
       UserInfo info=dao.fetch(mobile);
       if(info==null){
    	   resp.getWriter().print("<h1>Invalid Mobile Number</h1>");
    	   req.getRequestDispatcher("Login.html").include(req, resp);
                     }
       else{
    	   if(info.getPassword().equals(password)){
    		   resp.getWriter().print("<h1>Login Success</h1>");
    		   // resp.sendRedirect("https://www.youtube.com");
    	   }
    	   else{
    		   resp.getWriter().print("<h1>Invalid Password</h1>");
       		   req.getRequestDispatcher("Login.html").include(req, resp);
    	   }
           }
       }
	catch(NumberFormatException e){
		String email=emph;
		UserInfo info=dao.fetch(email);
	       if(info==null){
	    	   resp.getWriter().print("<h1>Invalid emailid</h1>");
	    	   req.getRequestDispatcher("Login.html").include(req, resp);
	       }
	       else{
	    	   if(info.getPassword().equals(password)){
	    		   resp.getWriter().print("<h1>Login Success</h1>");
	    		   req.setAttribute("list", list);
	    		   req.getRequestDispatcher("Home.jsp").include(req, resp);
	   		//	resp.getWriter().print("<h1 style='color:purple'>login successfully</h1>");
	   		//	out.print("<table border='1'>");
	   		//	out.print ("<tr>");
	   		//	out.print("<th>Id</th>");
	   		//	out.print("<th>Name</th>");
	   		//	out.print("<th>Email</th>");
	   		//	out.print("<th>Password</th>");
	   		//	out.print("<th>Mobile</th>");
	   		//	out.print("<th>Address</th>");
	   		//	out.print("<th>Gender</th>");
	   		//	out.print("<th>Date</th>");
	   		//	out.print("<th>Country</th>");
	   			// out.print("</tr>");
	   	
	                // for(UserInfo user2:list){
	               	 // out.print ("<tr>");
	         		//	out.print("<th>"+user2.getId()+"</th>");
	         		//	out.print("<th>"+user2.getName()+"</th>");
	         		//	out.print("<th>"+user2.getEmail()+"</th>");
	         		//	out.print("<th>"+user2.getPassword()+"</th>");
	         		//	out.print("<th>"+user2.getMobile()+"</th>");
	         		//	out.print("<th>"+user2.getAddress()+"</th>");
	         		//	out.print("<th>"+user2.getGender()+"</th>");
	         		//	out.print("<th>"+user2.getDate()+"</th>");
	         		//	out.print("<th>"+user2.getCountry()+"</th>");
	         		//	out.print("</tr>");
	              //   }
	            //     out.print("</table>");
	    	   }
	    	   else{
	    		   resp.getWriter().print("<h1>Invalid Password</h1>");
	    		   req.getRequestDispatcher("Login.html").include(req, resp);
	    		  
                   }

		
		    	   }
		       }
			
			
		
		}
	}
