<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pathology Registration</title>
    
<jsp:include page="header.html"/>
</head>
<body>
 <div class="agileits grid_3 grid_5 wow fadeInRight animated" data-wow-delay=".5s" style="margin-left:25%;">
			<h1 class="t-button">
				<a><span class="label label-success">Pathology Registration</span></a>
				<a href="Login.jsp" ><span class="label label-primary">Login</span></a>
				<a href="DonorPatientReg.jsp" ><span class="label label-primary">Donor Patient Registration</span></a>
			</h1>
</div>
<div style="margin-left:25%;padding:1px 16px;">

<form name="registration" action="RegisterDP" method="post">
<input type="hidden" name="pagename" value="PathologyReg">
<table>
<tr>
<td><h3>Pathology Registration</h3></td>
</tr>
<tr>
<td>Pathology Name:</td>
<td><input type="text" name="pathname" required></td>
</tr>
<tr>
<td>Assistant Name:</td>
<td><input type="text" name="aname" required></td>
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
<option value="Delhi" >Delhi</option>
<option value="Haryana"  >Haryana</option>
<option value="Rajasthan" >Rajasthan</option>
<option value="Punjab" >Punjab</option>
<option value="Uttara Khand" >Uttara Khand</option>
<option value="Uttar Pradesh" >Uttar Pradesh</option>
<option value="Madhya Pradesh" >Madhya Pradesh</option>
</select></td>
</tr>
<tr>
<td>City:</td>
<td><input type="text" name="city"required></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="address" required></td>
</tr>
<tr>
<td>Available Tests:</td>
<td>
Test 1<input type="text" name="test1"required><br/>
Test 2<input type="text" name="test2"><br/>
Test 3<input type="text" name="test3"><br/>
Test 4<input type="text" name="test4"><br/>
Test 5<input type="text" name="test5"><br/>
Test 6<input type="text" name="test6"><br/>
Test 7<input type="text" name="test7"><br/>
</td>
</tr>
<tr>
<td>Contact No.:</td>
<td><input type="text" name="phone" required></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="text" name="email"required></td>
</tr>
<tr>
        <td>
            Password:
        </td>
        <td>
            <input type="password" id="txtPassword" name="password" required/>
        </td>
    </tr>
    <tr>
        <td>
            Confirm Password:
        </td>
        <td>
            <input type="password" id="txtConfirmPassword" required/>
        </td>
    </tr>
    <tr>
        <td>
        </td>
        <td>
            <input type="submit" id="btnSubmit" value="Submit" required/>
        </td>
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