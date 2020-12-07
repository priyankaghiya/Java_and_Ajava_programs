<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="std" class="bean.Student"></jsp:useBean> <!-- std is the object that is created of the class Student -->

<%
out.println("<br> ROLL NO : "+std.getRoll());
out.println("<br> NAME : "+std.getName());

std.setRoll(400);
std.setName("PIYU");
out.println("<br> ROLL NO : "+std.getRoll());
out.println("<br> NAME : "+std.getName());


%>
<form name="f1" action="hello">

ENTER MARKS1 : <input type="text" name="t1"> <br>
ENTER MARKS2 : <input type="text" name="t2"> <br>
ENTER MARKS3 : <input type="text" name="t3"> <br> 

<input type="submit" name="sub" value="RESULT">

</form>


</body>
</html>