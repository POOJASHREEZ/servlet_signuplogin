<%@page import="org.apache.catalina.User"%>
<%@page import="dto.UserInfo"%>
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
<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th>Password</th>
<th>Address</th>
<th>Country</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%  List<UserInfo> list=(List<UserInfo>)request.getAttribute("list"); 
for(UserInfo userinfo:list){%>
<tr>
<th><%=userinfo.getId() %></th>
<th><%=userinfo.getName() %></th>
<th><%=userinfo.getEmail() %></th>
<th><%=userinfo.getMobile() %></th>
<th><%=userinfo.getPassword() %></th>
<th><%=userinfo.getAddress() %></th>
<th><%=userinfo.getCountry() %></th>
<th><a href="edit.jsp?id=<%=userinfo.getId()%>" ><button>Edit</button></a></th>
<th><a href="delete?id=<%=userinfo.getId()%>"><button>Delete</button></a></th>
</tr>
<% } %>
</table>
</body>
</html>