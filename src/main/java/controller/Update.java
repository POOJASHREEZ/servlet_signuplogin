package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserInfo;

@WebServlet("/update")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserInfo userinfo=new UserInfo();
		userinfo.setEmail(req.getParameter("email"));
		userinfo.setMobile(Long.parseLong(req.getParameter("mob")));
		userinfo.setName(req.getParameter("name"));
		userinfo.setPassword(req.getParameter("pwd"));
		userinfo.setId(Integer.parseInt(req.getParameter("id")));
		
		UserDao dao=new UserDao();
		dao.update(userinfo);
		
		resp.getWriter().print("<h1>Data Updated successfully</h1>");
		req.setAttribute("list", dao.fetchAll());
		req.getRequestDispatcher("Home.jsp").include(req, resp);
		
		
				
		
		
	}
	

}
