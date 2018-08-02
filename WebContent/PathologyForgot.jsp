<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<jsp:include page="header.html"/>
</head>
<body>	
<div class="agileits grid_3 grid_5 wow fadeInRight animated" data-wow-delay=".5s" style="margin-left:25%;">
			<h1 class="t-button">
				<a><span class="label label-success">Forgot Password</span></a>
			</h1>
</div>
<div style="margin-left:25%;padding:1px 16px;">
<form name="login" action="Forgot" method="post">
<input type="hidden" name="pagename" value="Forgot"/>
<table >
<tr><td>E-mail</td>
<td><input type="text" name="u-id" required></td></tr>
<tr><td>Contact Number</td>
<td><input type="text" name="number" required></td></tr>
<tr><td><input type="submit" value="Submit"></td></tr>
<tr><td style="color:red">${error}</td></tr>
<tr><td style="color:blue"><a href="Login.jsp">Login</a><td style="color:blue"><a href="Login.jsp">   Sign Up</a></td></tr>
</table>
</form>
</div>
<jsp:include page="footer.html"/>
</body>
</html>