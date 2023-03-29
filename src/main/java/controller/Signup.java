package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

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

@WebServlet("/signup")
public class Signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date=Date.valueOf(req.getParameter("dob"));
	    String name;
	    long mobile;	
        String email;
        String password;
        Date date11;
        String gender;
		String address;
        String country;
        String[] skills;    
    Date date1=Date.valueOf(req.getParameter("dob"));
     
    UserInfo info=new UserInfo();
    info.setAddress(req.getParameter("address"));
    info.setCountry(req.getParameter("country"));
    info.setDate(Date.valueOf(req.getParameter("dob")));
    info.setEmail(req.getParameter("email"));
    info.setGender(req.getParameter("gender"));
    info.setMobile(Long.parseLong(req.getParameter("mob")));
    info.setName(req.getParameter("name"));
    info.setPassword(req.getParameter("pwd"));
    info.setSkills(req.getParameterValues("skills"));
    
    info.setAge(Period.between(date1.toLocalDate(), LocalDate.now()).getYears());
    
    UserDao dao=new UserDao();
    dao.save(info);
    
    resp.getWriter().print("<h1 style='color:hotpink'> Account Created Successfully</h1>");
    req.getRequestDispatcher("Login.html").include(req, resp);
    
   // res.getWriter().print("<h1 style='color:green'>"
    //		+ "<br>Name:"+name
    	//	+ "<br>Mobile:"+mobile
//    		+ "<br>Email:"+email
//    		+ "<br>Password:"+password
//    		+ "<br>Date:"+date
//    		+ "<br>Gender:"+gender
//    		+ "<br>Address:"+address
//    		+ "<br>Country:"+country
//    		+ "<br>Skills:"+Arrays.toString(skills)
//    		+ "</h1>");
	}

}