<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpringMVC form</title>
</head>
<body>

<div style="border-style:solid; width:400px;margin-bottom:10px">
<form method="POST">
	<input name="name" type="text" />
	<input type="submit" value="submit"> 
</form>
</div>

<div style="border-style:solid; width:400px">
<form:form method="POST" commandName="book">
	<form:input path="name"/>
	<input type="submit" value="submit"> 
</form:form>
</div>

</body>
</html>