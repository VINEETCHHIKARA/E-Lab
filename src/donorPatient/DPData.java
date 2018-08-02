package donorPatient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;

import admin.GetSet;
import mail.SendEmail;
import admin.AdminData;;
public class DPData {

	public Connection connect() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/";
		String user="root";
		String db="e-lab";
		String pass="root";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url+db,user,pass);
		return conn;
	}
	public boolean getConnection(GetSet v) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn=connect();
		boolean status=false;
		String sql="INSERT INTO `e-lab`.`donorpatient` (`fname`, `lname`, `gender`, `dob`, `state`, `city`, `address`, `bloodgroup`, `blooddonor`, `lastdateofdonation`, `phone`, `email`, `password`, `tc`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? );";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, v.getFname());
		ps.setString(2, v.getLname());
		ps.setString(3, v.getGender());
		ps.setString(4,v.getDob());
		ps.setString(5, v.getState());
		ps.setString(6, v.getCity());
		ps.setString(7, v.getAddress());
		ps.setString(8, v.getBgroup());
		ps.setString(9, v.getBlooddonor());
		ps.setString(10,v.getLastdonate());
		ps.setString(11, v.getPhone());
		ps.setString(12, v.getEmail());
		ps.setString(13, v.getPassword());
		ps.setString(14, v.getTc());
		status=ps.execute();
		conn.close();
		return status;
	}

	public boolean login(GetSet set) throws ClassNotFoundException, SQLException {
		
		Connection conn=connect();
		boolean i=false;
		String sql="SELECT * FROM `e-lab`.pathologyreg where email=\""+set.getUserName()+"\";\r\n" +"";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet res = st.executeQuery(sql);
		  while (res.next()) {
		  String q = res.getString("email");
		  String r = res.getString("password");
		  String name=res.getString("aname");
		  String pname=res.getString("pathname");
		  if(q.equals(set.getUserName())&&r.equals(set.getPassword())) {
			  set.setLname("Pathology");
			  set.setPathname(pname);
			  set.setFname(name);
			  i=true;
			  break;
		  }
		  }
		  if(!i) {
			  set.setLname("client");
			sql="SELECT * FROM `e-lab`.`donorpatient` where email=\""+set.getUserName()+"\";\r\n" +"";
			st = conn.prepareStatement(sql);
			res = st.executeQuery(sql);
			while (res.next()) {
				  String q = res.getString("email");
				  String r = res.getString("password");
				  String name=res.getString("fname")+" "+res.getString("lname");
				  if(q.equals(set.getUserName())&&r.equals(set.getPassword())) {
					  set.setFname(name);
					  i=true;
					  break;
				  }
				  }			  
		  }
		  if(!i) {
			  set.setLname("admin");
			sql="SELECT * FROM `e-lab`.admin where email=\""+set.getUserName()+"\";\r\n" +"";
			st = conn.prepareStatement(sql);
			res = st.executeQuery(sql);
			while (res.next()) {
				  String q = res.getString("email");
				  String r = res.getString("password");
				  String name=res.getString("name");
				  if(q.equals(set.getUserName())&&r.equals(set.getPassword())) {
					  set.setFname(name);
					  i=true;
					  break;
				  }
				  }			  
		  }
		  
		  conn.close();
		  return i;
	}
	public boolean forgot(String uid) throws ClassNotFoundException, SQLException, MessagingException {
		// TODO Auto-generated method stub
		System.out.println("we are in admin.forgot");
		Connection conn=connect();
		System.out.println("we are connection success");
		boolean i=false;
		String sql="SELECT * FROM `e-lab`.`donorpatient` where email=\""+uid+"\";\r\n" +"";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet res = st.executeQuery(sql);

		System.out.println("we are query success");
		  while (res.next()) {
		  String email = res.getString("email");
		  String pass = res.getString("password");
		  String name=res.getString("fname");
		  String lname=res.getString("lname");
		  String message="Mr./Mrs. "+name+" "+lname+",\n\t Your password is '"+pass+"' .You are requested to change your password which you can easily remember. \n \t Thankyou.";
		  if(email.equals(uid)) {
				System.out.println("we are in admin.forgot id match");
			  SendEmail mail=new SendEmail();
			  mail.mail(uid,message);
			  i=true;
			  break;
		  }
		  }
		return i;
		
	}
	
	public boolean getUpdate(String email, GetSet v) throws ClassNotFoundException, SQLException {
		Connection conn=connect();
		boolean status=false;
		//String query = "update users set num_points = ? where first_name = ?";
		String sql="UPDATE `e-lab`.`donorpatient` SET `fname`=?, `lname`=?, `gender`=?, `dob`=?, `state`=?, `city`=?, `address`=?, `bloodgroup`=?, `blooddonor`=?, `phone`=? WHERE email like ?;";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, v.getFname());
		ps.setString(2, v.getLname());
		ps.setString(3, v.getGender());
		ps.setString(4,v.getDob());
		ps.setString(5, v.getState());
		ps.setString(6, v.getCity());
		ps.setString(7, v.getAddress());
		ps.setString(8, v.getBgroup());
		ps.setString(9, v.getBlooddonor());
		ps.setString(10, v.getPhone());
		ps.setString(11, email);
		status=ps.execute();
		conn.close();
		return status;
	}
}
