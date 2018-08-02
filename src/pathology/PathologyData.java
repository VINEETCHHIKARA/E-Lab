package pathology;

import java.sql.Connection;
import donorPatient.DPData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;

import admin.GetSet;
import mail.SendEmail;
import admin.AdminData;
public class PathologyData {

	public boolean getConnection(String string, GetSet v) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/";
		String user="root";
		String db="e-lab";
		String pass="root";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url+db,user,pass);
		boolean status=false;
		System.out.println("Start");
		String sql="INSERT INTO `e-lab`.`pathologyreg` (`pathname`, `aname`, `gender`, `age`, `state`, `city`, `address`, `test1`, `test2`, `test3`, `test4`, `test5`, `test6`, `test7`, `phone`, `email`, `password`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, v.getPathname());
		ps.setString(2, v.getAname());
		ps.setString(3, v.getGender());
		ps.setInt(4, v.getAge());
		ps.setString(5, v.getState());
		ps.setString(6, v.getCity());
		ps.setString(7, v.getAddress());
		ps.setString(8, v.getTest1());
		ps.setString(9, v.getTest2());
		ps.setString(10,v.getTest3());
		ps.setString(11, v.getTest4());
		ps.setString(12,v.getTest5());
		ps.setString(13, v.getTest6());
		ps.setString(14,v.getTest7());
		ps.setString(15, v.getPhone());
		ps.setString(16, v.getEmail());
		ps.setString(17, v.getPassword());
		status=ps.execute();
		conn.close();
		return status;
	}

	public boolean forgot(String uid) throws ClassNotFoundException, SQLException, MessagingException {
		// TODO Auto-generated method stub
		System.out.println("we are in admin.forgot");
		AdminData add=new AdminData();
		Connection conn=add.connect();
		System.out.println("we are connection success");
		boolean i=false;
		String sql="SELECT * FROM `e-lab`.`pathologyreg` where email=\""+uid+"\";\r\n" +"";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet res = st.executeQuery(sql);

		System.out.println("we are query success");
		  while (res.next()) {
		  String email = res.getString("email");
		  String pass = res.getString("password");
		  String path=res.getString("pathname");
		  String name=res.getString("aname");
		  String message="Mr./Mrs. "+name+",\n\t Your password is '"+pass+"' ."+path+" ,You  are requested to change your password which you can easily remember. \n \t Thankyou.";
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

	
	public boolean setRequest(String page, GetSet v) throws ClassNotFoundException, SQLException {
		DPData dpData=new DPData();
		boolean i=false;
		Connection conn=dpData.connect();
		String sql="INSERT INTO `e-lab`.`requesttest` (`name`, `reqSender`,`reqReceiver`,  `test`, `date`, `address`, `phone`) VALUES ( ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, v.getAname());
		ps.setString(2, v.getUserName());
		ps.setString(3, v.getEmail());
		ps.setString(4,v.getTest1());
		ps.setString(5, v.getDob());
		ps.setString(6, v.getAddress());
		ps.setString(7, v.getPhone());
		i=ps.execute();
		conn.close();
		return i;
	}
}
