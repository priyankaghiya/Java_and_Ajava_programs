<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sql:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/gtukb"
					user="root" password="" var="mycon" />
	
<sql:query dataSource="${mycon}" var="result">select * from mytab; </sql:query>

<c:forEach var="row" items="${result.rows}">
<br>

<c:out value="${row.sid}"></c:out>
<c:out value="${row.sna}"></c:out>
<c:out value="${row.sag}"></c:out>
</c:forEach>


</body>
</html>