package mca;

import java.sql.* ; 
import java.math.* ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	public boolean getConnection(String form,GetSet v) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/";
		String user="root";
		String db="e-lab";
		String pass="root";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url+db,user,pass);
		boolean status=false;
		switch(form) {
		case "RegisterDP":
			status=registerDP(conn,v);
			break;
		case "PathologyReg":
			status=pathologyReg(conn,v);
			break;
		case "FeedBack":
			status=feedBack(conn,v);
			break;
		case "AddAdmin":
			status=addAdmin(conn,v);
			break;
		}
		return status;
	}
	public boolean registerDP(Connection conn1,GetSet v) throws SQLException {
		String sql="INSERT INTO `e-lab`.`donorpatient` (`fname`, `lname`, `gender`, `age`, `state`, `city`, `address`, `bloodgroup`, `blooddonor`, `lastdateofdonation`, `phone`, `email`, `password`, `tc`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? );";
		PreparedStatement ps=conn1.prepareStatement(sql);
		ps.setString(1, v.getFname());
		ps.setString(2, v.getLname());
		ps.setString(3, v.getGender());
		ps.setInt(4, v.getAge());
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
		boolean status=ps.execute();
		conn1.close();
		return status;
	}
	public boolean pathologyReg(Connection conn1,GetSet v) throws SQLException {

		System.out.println("Start");
		String sql="INSERT INTO `e-lab`.`pathologyreg` (`pathname`, `aname`, `gender`, `age`, `state`, `city`, `address`, `test1`, `test2`, `test3`, `test4`, `test5`, `test6`, `test7`, `phone`, `email`, `password`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps=conn1.prepareStatement(sql);
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
		boolean status=ps.execute();
		conn1.close();
		return status;
		
	}
	public boolean feedBack(Connection conn1,GetSet v) throws SQLException {
		String sql="INSERT INTO `e-lab`.`feedback` (`name`, `email`, `message`) VALUES (?, ?, ?);";
		PreparedStatement ps=conn1.prepareStatement(sql);
		ps.setString(1, v.getAname());
		ps.setString(2, v.getEmail());
		ps.setString(3, v.getMessage());
		boolean status=ps.execute();
		conn1.close();
		return status;
	}
	public boolean addAdmin(Connection conn1,GetSet v) throws SQLException {
		System.out.println("Start");
		String sql="INSERT INTO `e-lab`.`admin` (`name`,`email`,`phone`, `address`,  `password`) VALUES ( ?, ?, ?, ?, ?);";
		PreparedStatement ps=conn1.prepareStatement(sql);
		ps.setString(1, v.getFname());
		ps.setString(2, v.getEmail());
		ps.setString(3, v.getPhone());
		ps.setString(4, v.getAddress());
		ps.setString(5, v.getPassword());
		boolean status=ps.execute();
		System.out.println(v.getFname());
		System.out.println(v.getEmail());
		System.out.println(v.getPhone());
		System.out.println(v.getAddress());
		conn1.close();
		return status;
		
	}	
	public boolean login(GetSet set) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/";
		String user="root";
		String db="e-lab";
		String pass="root";
		String driver="mysql";
		Class.forName(driver);
		System.out.print("forName done");
		Connection conn=DriverManager.getConnection(url,user,pass);
		System.out.print("conn done");
		boolean i=false;
		i=Login(conn,set);
		  return i;
	}
	public boolean Login(Connection conn1,GetSet set) throws SQLException {
		String sql="SELECT * FROM `e-lab`.pathologyreg where email=\""+set.getUserName()+"\";\r\n" +"";
		PreparedStatement st = conn1.prepareStatement(sql);
		ResultSet res = st.executeQuery(sql);
		  boolean i=false;
		  while (res.next()) {
		  String q = res.getString("email");
		  String r = res.getString("password");
		  String name=res.getString("aname");
		  if(q.equals(set.getUserName())&&r.equals(set.getPassword())) {
			  set.setLname("Pathology");
			  set.setFname(name);
			  i=true;
			  break;
		  }
		  }
		  if(!i) {
			  set.setLname("client");
			sql="SELECT * FROM `e-lab`.`donorpatient` where email=\""+set.getUserName()+"\";\r\n" +"";
			st = conn1.prepareStatement(sql);
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
			st = conn1.prepareStatement(sql);
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
		  conn1.close();
		  return i;
	}
}