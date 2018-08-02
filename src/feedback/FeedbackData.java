package feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import admin.GetSet;

public class FeedbackData {

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
		String sql="INSERT INTO `e-lab`.`feedback` (`name`, `email`, `message`) VALUES (?, ?, ?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, v.getAname());
		ps.setString(2, v.getEmail());
		ps.setString(3, v.getMessage());
		status=ps.execute();
		conn.close();
		return status;
	}

}
