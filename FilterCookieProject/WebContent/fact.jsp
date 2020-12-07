<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
HttpSession ss=request.getSession(false);
String st=(String)ss.getAttribute("username");
out.println("<br> USER NAME : "+st);
%>


<form name="f2" action="fact">
ENTER NO : <input type="text" name="tno"><br><br>

<input type="submit" name="sub" value="FIND FACT">

</form>
</body>
</html>