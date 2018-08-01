package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mca.GetSet;

public class AdminData {

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
		String sql="INSERT INTO `e-lab`.`admin` (`name`,`email`,`phone`, `address`,  `password`) VALUES ( ?, ?, ?, ?, ?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, v.getFname());
		ps.setString(2, v.getEmail());
		ps.setString(3, v.getPhone());
		ps.setString(4, v.getAddress());
		ps.setString(5, v.getPassword());
		status=ps.execute();
		System.out.println(v.getFname());
		System.out.println(v.getEmail());
		System.out.println(v.getPhone());
		System.out.println(v.getAddress());
		conn.close();
		return status;
	}

}
