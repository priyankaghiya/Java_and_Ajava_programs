<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsf/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:view>
	
	ID : <h:outputText value="#{emp.eid}"> </h:outputText> <br>
	NAME : <h:outputText value="#{emp.ena}"> </h:outputText> <br>
	AGE : <h:outputText value="#{emp.eag}"> </h:outputText> <br>
	
	
	</c:view>
</body>
</html>