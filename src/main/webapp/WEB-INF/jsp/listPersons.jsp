<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List of persons</h1>
	<c:forEach var="person" items="${listPersons}">
         <b>ID</b> <c:out value="${person.id}" />
         <b>Name</b> <c:out value="${person.name}" />
         <b>Age</b> <c:out value="${person.age}" />
         <BR />
	</c:forEach>
</body>
</html>