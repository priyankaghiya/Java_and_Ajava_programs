<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %> <!-- tag library -->
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> <% Date d1=new Date();
out.println(d1);

Cookie c[]=request.getCookies();
int flag=0;
if(c!=null)
{
	for(int i=0;i<c.length;i++)
	{
		if(c[i].getName().equals("college") && c[i].getValue().equals("svit"))
		{
			flag=1;
			//request.getRequestDispactcher("/fact.jsp").forward(request,response);
		}
	}
}

if(flag==1)
{
request.getRequestDispatcher("/fact.jsp").forward(request, response);	
}
else
{

%></h1>



<form name="f1" action="LoginServlet">
USER NAME : <input type="text" name="tus"><br>
PASSWORD : <input type="password" name="tpa"><br>

<input type="checkbox" name="keep" value="kept">keep me logged in.....
<br><br>

<input type="submit" name="sub" value="LOGIN">
</form>
<% } %>
</body>
</html>