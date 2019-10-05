<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="styles/login-style.css" rel="stylesheet" type="text/css"/>
	<meta http-equi="Content-Type" content="text/html; charset=UTF-8">
	
	
	<title>Register here</title>
</head>

<body style="backgorund-color: #E6E6FA; text-align: center;">
	<img src="images/header.jpg">
	<form name="myForm" method="post">
	
	<div class="login-box">
	<h1>REGISTER</h1>
	
	<div>
		<label>Email</label>
		<input type="text" name="email" placeholder="enter email here">
	</div>
	
	<br>
	
	<div>
		<label>Password</label>
		<input type="text" name="password" placeholder="enter password here">	
	</div>
	
	<br>
	
	<button type="submit"  formaction="/clerkRegistered" class="btn">RegisterYourself</button>
	</div>
	</form>
</body>
</html>