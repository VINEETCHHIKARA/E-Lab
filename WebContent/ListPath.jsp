
							<%
							String state=request.getParameter("state");
							String bgroup=request.getParameter("bgroup");
							String url="jdbc:mysql://localhost:3306/";
							String user="root";
							String db="e-lab";
							String pass="root";
							String driver="com.mysql.jdbc.Driver";
							java.sql.Connection connection=null;
							try{
								Class.forName(driver);
	  							connection = java.sql.DriverManager.getConnection(url+db,user,pass);
								java.sql.Statement st = connection.createStatement();
								java.sql.ResultSet rs = st.executeQuery("SELECT * FROM `e-lab`.pathologyreg;");
								out.print("<br><table style='border:black solid; margin-left:100px; margin-top:50px;'><tr><td><b>Pathology Name</td><td><b>Assistent Name</td><td><b>Gender</td><td><b>State</td><td><b>City</td><td><b>Address</td><td><b>Number</td><td><b>E-mail</td><tr>");
								while(rs.next()){
									out.print("<tr><td>"+rs.getString("pathname")+"</td><td>"+rs.getString("aname")+"</td><td>"+rs.getString("gender")+"</td><td>"+rs.getString("state")+"</td><td>"+rs.getString("city")+"</td><td>"+rs.getString("address")+"</td><td>"+rs.getString("phone")+"</td><td>"+rs.getString("email")+"</td></tr>");
								}
								out.println("</table>");
								connection.close();
								}
								catch (Exception e){
								out.println(e);
								}
							%>