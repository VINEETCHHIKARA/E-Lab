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
				<a href="Login.jsp"><span class="label label-primary">Login</span></a>
				<a href="PathologyReg.jsp"><span class="label label-primary">Pathology Registration</span></a>
			</h1>
</div>
<div style="margin-left:25%;padding:1px 16px;">
<form name="registration" action="RegisterDP" method="post" >
<input type="hidden" name="pagename" value="registration"/>
<table>
<tr>
<td><h3>Donor/Patient Registration</h3></td>
</tr>
<tr>
<td>First Name:</td>
<td><input type="text" name="fname" required></td>
</tr>
<tr>
<td>Last Name:</td>
<td><input type="text" name="lname" required></td>
</tr>
<tr>
<td>Gender:</td>
<td><input type="radio" name="gender" id="male" value="male" required><label for="male">Male</label><input type="radio" name="gender" id="female" value="female" required><label for="male">Female</label></td>
</tr>
<tr>
<td>Age:</td>
<td><input type="text" name="age" required></td>
</tr>
<tr>
<td>State:</td>
<td><select name="state" required>
<option value="">None</option>
<option value="Delhi">Delhi</option>
<option value="Haryana">Haryana</option>
<option value="Rajasthan">Rajasthan</option>
<option value="Punjab">Punjab</option>
<option value="Uttara Khand">Uttara Khand</option>
<option value="Uttar Pradesh">Uttar Pradesh</option>
<option value="Madhya Pradesh">Madhya Pradesh</option>
</select></td>
</tr>
<tr>
<td>City:</td>
<td><input type="text" name="city"  required></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="address" required></td>
</tr>
<tr>
<td>Blood Group:</td>
<td><select name="bgroup">
<option value="A+">A+</option>
<option value="B+">B+</option>
<option value="O+">O+</option>
<option value="AB+">AB+</option>
<option value="A-">A-</option>
<option value="B-">B-</option>
<option value="O-">O-</option>
<option value="AB-">AB-</option>
<option value="Bombay">Bombay</option>
</select>
</td>
</tr>
<tr>
<td>Blood Donor:</td>
<td><input type="checkbox" name="blooddonor" ></td>
</tr>
<tr>
<td>Last date of blood donation:</td>
<td><input type="date" id="bday" name="lastdonate" ></td>
</tr>
<tr>
<tr>
<td>Contact No.:</td>
<td><input type="text" name="phone" required></td>
</tr>
<tr>
<tr>
<td>Email:</td>
<td><input type="text" name="email" required></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" id="txtPassword" name="password" required/></td>
</tr>
<tr>
<td>Confirm Password:</td>
<td><input type="password" id="txtConfirmPassword" required/></td>
</tr>
<tr>
<td>Terms and Conditions :</td>
<td><input type="checkbox" name="tc"><br/>I am not suffering from any of the diseases .</td>
</tr>
<tr>
<td></td>
<td><input type="submit" id="btnSubmit" value="Submit" /></td>
</tr>
</table>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#btnSubmit").click(function () {
            var password = $("#txtPassword").val();
            var confirmPassword = $("#txtConfirmPassword").val();
            if (password != confirmPassword) {
                alert("Passwords do not match.");
                return false;
            }
            return true;
        });
    });
</script>
</form>
</div> 
<jsp:include page="footer.html"/>   
</body>
</html>