package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public String mail(String to,String msg) throws MessagingException {
			
	      // Sender's email ID needs to be mentioned
	      String from = "YOUR EMAIL ADDRESS";

	      // Assuming you are sending email from localhost
	      String host = "smtp.gmail.com";

	      // Get system properties
	      String subject = "E-Lab";
	      final  String password ="YOUR PASSWORD";


	      Properties props = new Properties();  
	      props.setProperty("mail.transport.protocol", "smtp");     
	      props.setProperty("mail.host", host);  
	      props.put("mail.smtp.auth", "true");  
	      props.put("mail.smtp.port", "465");  
	      props.put("mail.debug", "true");  
	      props.put("mail.smtp.socketFactory.port", "465");  
	      props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	      props.put("mail.smtp.socketFactory.fallback", "false");  
	      Session session = Session.getDefaultInstance(props,  
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {  
	         return new PasswordAuthentication(from,password);  
	     }  
	     });  

	     //session.setDebug(true);  
	     Transport transport = session.getTransport();  
	     InternetAddress addressFrom = new InternetAddress(from);  

	     MimeMessage message = new MimeMessage(session);  
	     message.setSender(addressFrom);  
	     message.setSubject(subject);  
	     message.setContent(msg, "text/plain");  
	     message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

	     transport.connect();  
	     Transport.send(message);  
	     transport.close();
		return "Successfull";
	}
}
