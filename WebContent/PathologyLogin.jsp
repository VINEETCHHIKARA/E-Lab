<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pathology Login</title>
<jsp:include page="header.html"/>
</head>
<body>
<div style="margin-left:25%;padding:1px 16px;height:1000px;background-image: url(Blood4.jpg)">
<form name="login" action="RegisterDP" method="post">
<input type="hidden" name="pagename" value="Pathology Login"/>
<table style="margin-left:10%;margin-top:10%;padding:16px 16px;border:2px solid black;background-color:white;">
<tr><td><h3>Pathology Login</h3></td></tr>
<tr><td>E-mail</td>
<td><input type="text" name="u-id"></td></tr>
<tr><td>Password</td>
<td><input type="password" name="password"></td></tr>
<tr><td><input type="submit" value="Login"></td></tr>
<tr><td style="color:red">${message}</td></tr>
</table>
</form>
</div>
<jsp:include page="footer.html"/>
</body>
</html>