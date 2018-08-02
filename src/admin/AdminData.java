package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;

import mail.SendEmail;

public class AdminData {

	public Connection connect() throws ClassNotFoundException, SQLException {
		//String url="jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false";
		String url="jdbc:mysql://localhost:3306/";
		String user="root";
		String db="e-lab";
		String pass="root";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url+db,user,pass);
		return conn;
	}
	public boolean getConnection(String string, GetSet v) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conn=connect();
		boolean status=false;
		String sql="INSERT INTO `e-lab`.`admin` (`name`,`gender`,`age`,`email`,`phone`, `address`,  `password`) VALUES ( ?,?, ?, ?, ?, ?,?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, v.getFname());
		ps.setInt(3, v.getAge());
		ps.setString(2,v.getGender());
		ps.setString(4, v.getEmail());
		ps.setString(5, v.getPhone());
		ps.setString(6, v.getAddress());
		ps.setString(7, v.getPassword());
		status=ps.execute();
		System.out.println(v.getFname());
		System.out.println(v.getEmail());
		System.out.println(v.getPhone());
		System.out.println(v.getAddress());
		conn.close();
		return status;
	}

	public boolean forgot(String uid) throws ClassNotFoundException, SQLException, MessagingException {
		// TODO Auto-generated method stub
		System.out.println("we are in admin.forgot");
		Connection conn=connect();
		System.out.println("we are connection success");
		boolean i=false;
		String sql="SELECT * FROM `e-lab`.`admin` where email=\""+uid+"\";\r\n" +"";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet res = st.executeQuery(sql);

		System.out.println("we are query success");
		  while (res.next()) {
		  String email = res.getString("email");
		  String pass = res.getString("password");
		  String name=res.getString("name");
		  String message="Mr./Mrs. "+name+",\n\t Your password is '"+pass+"' .You are requested to change your password which you can easily remember. \n \t Thankyou.";
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
		String sql="UPDATE `e-lab`.`admin` SET `name`=?, `gender`=?, `age`=?, `phone`=?, `address`=? WHERE email like ?;";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, v.getFname());
		ps.setString(2,v.getGender());
		ps.setInt(3, v.getAge());
		ps.setString(4, v.getPhone());
		ps.setString(5, v.getAddress());
		ps.setString(6, email);
		status=ps.execute();
		System.out.println(v.getFname());
		System.out.println(v.getEmail());
		System.out.println(v.getPhone());
		System.out.println(v.getAddress());
		conn.close();
		return status;
	}
}
