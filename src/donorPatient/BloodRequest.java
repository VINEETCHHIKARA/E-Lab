package donorPatient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import mail.SendEmail;

public class BloodRequest {
	public void sendRequest(String receiver,String sender) throws ClassNotFoundException, SQLException, MessagingException {
		DPData dpData=new DPData();
		Connection conn=dpData.connect();
		String state=null;
		String address=null;
		String phone=null;
		String name=null;
		String sql="SELECT * FROM `e-lab`.donorpatient where email=\""+sender+"\";\r\n" +"";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet res = st.executeQuery(sql);
		  while (res.next()) {
			  state= res.getString("state");
			  address= res.getString("address");
			  phone= res.getString("phone");
			  name= res.getString("fname")+" "+res.getString("lname");
		sql="INSERT INTO `e-lab`.`request` (`reqReceiver`, `reqSander`, `state`, `address`, `phone`,`name`) VALUES (?,?,?,?,?,?);";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,receiver );
		ps.setString(2,sender);
		ps.setString(3, state);
		ps.setString(4, address);
		ps.setString(5, phone);
		ps.setString(6, name);
		ps.execute();
		String message="Mr./Mrs. "+name+"\n\tYou have received a blood donotion request. If you are ready to donate blood,Please response on Contect "+phone+".\nThankyou";
		SendEmail mail=new SendEmail();
		mail.mail(receiver,message);
		}
		conn.close();
	}
}
