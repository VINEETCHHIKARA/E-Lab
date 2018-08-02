<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donor/Patient Registration</title>
<jsp:include page="header.html"/>
</head>
<body>
 <div class="agileits grid_3 grid_5 wow fadeInRight animated" data-wow-delay=".5s" style="margin-left:25%;">
			<h1 class="t-button">
				<a><span class="label label-success">Donor Patient Registration</span></a>
				<a href="Login.jsp" ><span class="label label-primary">Login</span></a>
				<a href="PathologyReg.jsp" ><span class="label label-primary">Pathology Registration</span></a>
			</h1>
</div>
<div style="margin-left:25%;padding:1px 16px;">
<jsp:include page="addDP.html"/>  
</div> 
<jsp:include page="footer.html"/>   
</body>
</html>