<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="styles/login-style.css" rel="stylesheet" type="text/css"/>
		<meta http-equi="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	
	
	
	<body style="backgorund-color: #E6E6FA; text-align: center;">
	<img src="images/header.jpg">
	
	<font color="red">${errorMessage}</font>
		
	<form method="post">
	
		<div class="login-box">
			<img src="images/avatar.png" class="avatar">
	
			<h1>SIGN IN</h1>
			
				<div>
					<label>Email</label>
					<input type="text" name="email" class="form-control" placeholder="enter username here">
				</div>
			
			<br>
				
				<div>
					<label>Password</label>
					<input type="text" name="password" class="form-control" placeholder="enter password here">	
				</div>
			
			
				<br><button type="submit"  formaction="/loginAsClerk" value="signin" class="btn">Login as Clerk</button></br>
				<br><button type="submit"  formaction="/registerClerk" value="signup" class="btn">Register as Clerk</button></br>
				<br><button type="reset" class="btn">Reset</button></br>
		</div>>
	</form>
</body>
</html>