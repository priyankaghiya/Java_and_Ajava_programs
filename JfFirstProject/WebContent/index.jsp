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

<c:view><!-- jsf ni andar client ne kasu bhi batavu hoi toh u must write  view-->
		
		<h:form>
		
		ENTER ID : <h:inputText value="#{std.sid }"> </h:inputText> <br>
		ENTER NAME : <h:inputText value="#{std.sna }"> </h:inputText> <br>
		ENTER AGE : <h:inputText value="#{std.sag }"> </h:inputText> <br><br>
		
		<h:commandButton value="SUBMIT" action="#{std.nextPage}"></h:commandButton>
		
		</h:form>
</c:view>

</body>
</html>