<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<font color="red">${errorMessage}</font>
	<form method="post">
		Email : <input type="text" name="email" /> 
		Password : <input type="password" name="password" /> 

		<button type="submit" formaction="/loginAsClerk">Login as Clerk</button>
		<button type="submit" formaction="/registerClerk">Register as Clerk</button>
	</form>
</body>
</html>