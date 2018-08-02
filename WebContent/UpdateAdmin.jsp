
<%
String url="jdbc:mysql://localhost:3306/";
String user="root";
String db="e-lab";
String pass="root";
String driver="com.mysql.jdbc.Driver";

String email=session.getAttribute("email").toString();
java.sql.Connection connection=null;
	try{
Class.forName(driver);
	connection = java.sql.DriverManager.getConnection(url+db,user,pass);
java.sql.Statement st = connection.createStatement();
java.sql.ResultSet rs = st.executeQuery("SELECT * FROM `e-lab`.admin where email like '"+email+"';");
while(rs.next()){
out.print("<br><form name='registration' action='Admin' method='post' >");
out.print("<input type='hidden' name='pagename' value='Update'/><table style='border:black solid; margin-left:100px; margin-top:50px;'><tr><td><h3>Update Profile</h3></td></tr>");
out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+rs.getString("name")+"'required></td></tr>");
if(rs.getString("gender").equals("male")){
	out.print("</tr><tr><td>Gender:</td><td><input type='radio' name='gender' id='male' value='male' checked='checked' required><label for='male'>Male</label><input type='radio' name='gender' id='female' value='female' required><label for='male'>Female</label></td>");
}
else{
	out.print("</tr><tr><td>Gender:</td><td><input type='radio' name='gender' id='male' value='male' required><label for='male'>Male</label><input type='radio' name='gender' id='female' value='female' checked='checked' required><label for='male'>Female</label></td>");
}
out.print("</tr><tr><td>Age:</td><td><input type='date' name='age' value='"+rs.getString("age")+"' required></td></tr>");
out.print("<tr><td>Address:</td><td><input type='text' name='address' value='"+rs.getString("address")+"' required></td></tr>");
out.print("<tr><tr><td>Contact No.:</td><td><input type='text' name='phone' pattern='[0-9]{10}' value='"+rs.getString("phone")+"'required ></td></tr><tr><td>");
}

out.print("<input type='submit'id='btnSubmit' value='Submit' />");		
out.print("</td></tr></table>");
connection.close();
	}
	catch (Exception e){
	out.println(e);
	}
%>