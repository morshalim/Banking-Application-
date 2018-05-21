/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class forgotpassword extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException	
	{
		try
		{
			final String fromEmail = "You Gmail";//Enter your mailid
			final String password = "Your Gmail password";//Enter your password
			String toEmail=request.getParameter("email");
			System.out.println("forgot email is "+toEmail);
			HttpSession session=request.getSession(true);
			session.setAttribute("toEmail",toEmail);
			System.out.println("session email "+session.getAttribute("toEmail"));
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			
			Session session1 = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(fromEmail, password);
				}
			});
			
			MimeMessage mesg = new MimeMessage(session1);
			mesg.setFrom(new InternetAddress(fromEmail));
			mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			mesg.setSubject("DO NOT REPLY TO THIS EMAIL");  
			mesg.setText("Hello user.."
					+ "We received a request to reset your BankApp password. Click the link below to choose a new one:"
					+ " http://localhost:5944/BankApp/newPassword.jsp "//Replace 5944 with your Port Number
					+ "If you did not make this request or need assistance, please call immediately");  
		    Transport.send(mesg);
		    System.out.println("Executed mail");
		    response.sendRedirect("/BankApp/successpassword.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}

