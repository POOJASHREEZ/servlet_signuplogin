<%@page import="dto.UserInfo"%>
<%@page import="dao.UserDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
UserDao dao=new UserDao();
UserInfo userinfo=dao.fetch(id);
%>
<h1> Enter Your Details</h1><br>
<form action="update" method="post">
<table>
<tr>
<th>Id: </th>
<td><input type="text" value="<%=userinfo.getId()%>" readonly="readonly" name="id"></td>
</tr>
<tr>
<th>Name: </th>
<td><input type="text" value="<%=userinfo.getName()%>" name="name"></td>
</tr>
<tr>
<th>Mobile: </th>
<td><input type="tel" value="<%=userinfo.getMobile()%>" name="mob"></td>
</tr>
<tr>
<th>Email: </th>
<td><input type="email" value="<%=userinfo.getEmail()%>" name="email"></td>
</tr>
<tr>
<th>Password: </th>
<td><input type="password" value="<%=userinfo.getPassword()%>" name="pwd"></td>
</tr>
<tr>
<th>date of birth: </th>
<td><input type="text" value="<%=userinfo.getDate()%>" name="dob"></td>
</tr>
<tr>

<td><button type="reset">Cancel</button></td>
<td><button >Update</button>
</tr>




</table>



</form>
</body>
</html>